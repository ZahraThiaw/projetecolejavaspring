package sn.odc.oumar.springproject.Web.Controller.Impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.odc.oumar.springproject.Datas.Entity.Competence;
import sn.odc.oumar.springproject.Datas.Entity.Module;
import sn.odc.oumar.springproject.Datas.Entity.Referentiel;
import sn.odc.oumar.springproject.Services.Interfaces.CompetenceService;
import sn.odc.oumar.springproject.Services.Interfaces.ModuleService;
import sn.odc.oumar.springproject.Services.Interfaces.ReferentielService;
import sn.odc.oumar.springproject.Services.Interfaces.ResponseService;
import sn.odc.oumar.springproject.Web.Controller.BaseControllerImpl;
import sn.odc.oumar.springproject.Web.Controller.Interfaces.ReferentielControllerInterface;
import sn.odc.oumar.springproject.Web.Dtos.Request.*;
import sn.odc.oumar.springproject.Web.Dtos.Response.BaseResponse;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/referentiels")

@Tag(name = "Referentiels", description = "API pour gérer les référentiels")
public class ReferentielControllerImpl extends BaseControllerImpl<Referentiel, ReferentielDTO, Long> implements ReferentielControllerInterface {

    protected ReferentielService referentielService;
    protected  CompetenceService competenceService;
    protected ModuleService moduleService;
    @Autowired
    protected ResponseService responseService;

    @Autowired
    public ReferentielControllerImpl(ReferentielService referentielService, CompetenceService competenceService, ModuleService moduleService) {
        super(referentielService); // Corriger la superclasse ici
        this.referentielService = referentielService;
        this.competenceService = competenceService;
        this.moduleService = moduleService;
    }

    @PostMapping("create")
    public ResponseEntity<BaseResponse<Referentiel>> createReferentiel(@Valid @RequestBody ReferentielDTO referentielRequestDTO) {
        try {
            if (referentielService.existsByLibelle(referentielRequestDTO.getLibelle())) {
                return responseService.notFoundResponse( "libelle already exists");
            }

            // Mapper le DTO à l'entité Referentiel
            Referentiel referentiel = convertToEntity(referentielRequestDTO); // Utiliser la méthode de conversion

            // Sauvegarder le Référentiel
            Referentiel savedReferentiel = referentielService.create(referentiel);

            // Mapper les compétences et les modules du DTO
            if (referentielRequestDTO.getCompetences() != null) {
                Set<Competence> competences = referentielRequestDTO.getCompetences().stream()
                        .map(compDTO -> {
                            Competence competence = new Competence();
                            competence.setNom(compDTO.getNom());
                            competence.setDescription(compDTO.getDescription());
                            competence.setDureeAcquisition(compDTO.getDureeAcquisition());
                            competence.setType(Competence.Type.valueOf(compDTO.getType()));
                            competence.setReferentiel(savedReferentiel);

                            // Mapper les Modules
                            Set<Module> modules = compDTO.getModules().stream()
                                    .map(modDTO -> {
                                        Module module = new Module();
                                        module.setNom(modDTO.getNom());
                                        module.setDescription(modDTO.getDescription());
                                        module.setDureeAcquisition(modDTO.getDureeAcquisition());
                                        module.setCompetence(competence);
                                        return module;
                                    }).collect(Collectors.toSet());

                            competence.setModules(modules);
                            return competence;
                        }).collect(Collectors.toSet());
                savedReferentiel.setCompetences(competences);
            }

            // Retourner l'entité référentiel sauvegardée
            return responseService.successResponse(savedReferentiel, "Entities retrieved successfully");
        } catch (Exception e) {
            return responseService.errorResponse(e.getMessage());
        }
    }

    // ... (autres méthodes de votre contrôleur)

    @Override
    protected Referentiel convertToEntity(ReferentielDTO referentielDTO) {
        Referentiel referentiel = new Referentiel();
        referentiel.setLibelle(referentielDTO.getLibelle());
        referentiel.setDescription(referentielDTO.getDescription());
        referentiel.setPhotoCouverture(referentielDTO.getPhotoCouverture());
        return referentiel;
    }

    @Override
    protected ReferentielDTO convertToDto(Referentiel entity) {
        ReferentielDTO dto = new ReferentielDTO();
        dto.setLibelle(entity.getLibelle());
        dto.setDescription(entity.getDescription());
        dto.setPhotoCouverture(entity.getPhotoCouverture());
        // Ajoutez d'autres mappings nécessaires
        return dto;
    }
}
