package sn.odc.oumar.springproject.Services.Impl;

import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sn.odc.oumar.springproject.Datas.Entity.Apprenant;
import sn.odc.oumar.springproject.Datas.Entity.PromoReferentiel;
import sn.odc.oumar.springproject.Datas.Entity.Role;
import sn.odc.oumar.springproject.Datas.Entity.User;
import sn.odc.oumar.springproject.Datas.Repository.Interfaces.*;
import sn.odc.oumar.springproject.Exceptions.ServiceException;
import sn.odc.oumar.springproject.Services.Interfaces.ApprenantService;
import sn.odc.oumar.springproject.Web.Dtos.Request.ApprenantDTO;
import sn.odc.oumar.springproject.Web.Mappers.ApprenantMapper;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class ApprenantServiceImpl extends BaseServiceImpl<Apprenant,Long> implements ApprenantService {
    protected ApprenantRepository apprenantRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final PromoReferentielRepository promotionReferentielRepositoryImpl ;
    @Autowired
    public ApprenantServiceImpl(ApprenantRepository apprenantRepository,
                                UserRepository userRepository,
                                PasswordEncoder passwordEncoder,
                                RoleRepository roleRepository,
                                PromoReferentielRepository promotionReferentielRepositoryImpl

    ) {
        super(apprenantRepository);
        this.apprenantRepository = apprenantRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.promotionReferentielRepositoryImpl = promotionReferentielRepositoryImpl;
    }

    @Transactional
    public Apprenant createApprenant(ApprenantDTO apprenantDTO) {
        System.out.println("Creating Apprenant");
        try {



        // Créer l'utilisateur à partir des données du DTO
        User user = new User();
        user.setNom(apprenantDTO.getUser().getNom());
        user.setPrenom(apprenantDTO.getUser().getPrenom());
        user.setAdresse(apprenantDTO.getUser().getAdresse());
        user.setPhoto(apprenantDTO.getUser().getPhoto());
        user.setTelephone(apprenantDTO.getUser().getTelephone());
        user.setEmail(apprenantDTO.getUser().getEmail());
            Role role = roleRepository.findById(apprenantDTO.getUser().getRole_id())
                    .orElseThrow(() -> new ServiceException("Role not found"));
            user.setRole(role);

            // Hacher le mot de passe
        user.setPassword(passwordEncoder.encode(apprenantDTO.getUser().getPassword()));

        // Sauvegarder l'utilisateur
        user = userRepository.save(user);

        // Créer l'apprenant à partir des données du DTO
        Apprenant apprenant = new Apprenant();
        apprenant.setNom_tuteur(apprenantDTO.getNomTuteur());
        apprenant.setPrenom_tuteur(apprenantDTO.getPrenomTuteur());
        apprenant.setContact_tuteur(apprenantDTO.getContactTuteur());
        apprenant.setCni_file(apprenantDTO.getCniFile());
        apprenant.setExtrait_file(apprenantDTO.getExtraitFile());
        apprenant.setDiplome_file(apprenantDTO.getDiplomeFile());
        apprenant.setCasier_file(apprenantDTO.getCasierFile());
        apprenant.setPhoto_couverture(apprenantDTO.getPhotoCouverture());
        apprenant.setEtat(Apprenant.Etat.valueOf(apprenantDTO.getEtat()));
            // Récupérer l'ID du PromoReferentiel depuis le DTO
            Long promoReferentielId = apprenantDTO.getPromoReferentielId();


            PromoReferentiel promoReferentiel = promotionReferentielRepositoryImpl.findById(promoReferentielId)
                    .orElseThrow(() -> new ServiceException("PromoReferentiel not found"));
            apprenant.setPromoReferentiel(promoReferentiel);


            // Associer l'utilisateur à l'apprenant
        apprenant.setUser(user);


        // Sauvegarder l'apprenant
        return apprenantRepository.save(apprenant);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void insertMultipleApprenantsFromExcel(MultipartFile file) {
        List<ApprenantDTO> apprenantDTOList = new ArrayList<>();
        try {
            // Ouvrir le fichier Excel
            InputStream inputStream = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Suppose que les données sont dans la première feuille

            // Lire les lignes du fichier Excel
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Commence à 1 pour sauter l'en-tête
                Row row = sheet.getRow(i);
                ApprenantDTO apprenantDTO = new ApprenantDTO();

                // Exemple : Lecture des cellules et mapping dans ApprenantDTO
                apprenantDTO.getUser().setNom(row.getCell(0).getStringCellValue());
                apprenantDTO.getUser().setPrenom(row.getCell(1).getStringCellValue());
                apprenantDTO.getUser().setAdresse(row.getCell(2).getStringCellValue());
                apprenantDTO.getUser().setTelephone(row.getCell(3).getStringCellValue());
                apprenantDTO.getUser().setEmail(row.getCell(4).getStringCellValue());
                apprenantDTO.getUser().setPassword(row.getCell(5).getStringCellValue());
                apprenantDTO.setNomTuteur(row.getCell(6).getStringCellValue());
                apprenantDTO.setPrenomTuteur(row.getCell(7).getStringCellValue());
                apprenantDTO.setContactTuteur(row.getCell(8).getStringCellValue());
                apprenantDTO.setPromoReferentielId((long) row.getCell(9).getNumericCellValue());

                // Ajouter le DTO à la liste
                apprenantDTOList.add(apprenantDTO);
            }

            // Sauvegarder chaque apprenant en utilisant la méthode createApprenant
            for (ApprenantDTO apprenantDTO : apprenantDTOList) {
                createApprenant(apprenantDTO);
            }

            workbook.close();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'importation du fichier Excel : " + e.getMessage());
        }
    }

}
