package sn.odc.oumar.springproject.Services.Impl;

import sn.odc.oumar.springproject.Datas.Entity.Promo;
import sn.odc.oumar.springproject.Datas.Repository.Interfaces.PromoRepository;
import sn.odc.oumar.springproject.Services.Interfaces.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.odc.oumar.springproject.Services.Interfaces.ReferentielService;

import java.util.Optional;

@Service
public class PromoServiceImpl  extends BaseServiceImpl<Promo, Long>  implements PromoService {

    private final PromoRepository promoRepository;

    @Autowired
    public PromoServiceImpl(PromoRepository promoRepository) {
        super(promoRepository);
        this.promoRepository = promoRepository; // Correction de l'affectation
        // Ajout du référentiel
    }

    //à redéfinir
    @Override
    public Promo create(Promo promo) {
        return promoRepository.save(promo);
    }


    @Override
    public boolean promoExists(String libelle) {
        return promoRepository.existsByLibelle(libelle); // Assurez-vous d'avoir une méthode dans votre repo
    }


}
