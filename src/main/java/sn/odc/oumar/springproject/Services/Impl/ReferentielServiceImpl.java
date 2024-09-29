package sn.odc.oumar.springproject.Services.Impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.odc.oumar.springproject.Datas.Entity.Referentiel;
import sn.odc.oumar.springproject.Datas.Repository.Interfaces.ReferentielRepository;
import sn.odc.oumar.springproject.Exceptions.ServiceException;
import sn.odc.oumar.springproject.Services.Interfaces.ReferentielService;

import java.util.List;
import java.util.Optional;

@Service
public class ReferentielServiceImpl extends BaseServiceImpl<Referentiel, Long> implements ReferentielService {
    private static ReferentielRepository referentielRepository;

    @Autowired
    public ReferentielServiceImpl(ReferentielRepository referentielRepository) {
        super(referentielRepository);
        ReferentielServiceImpl.referentielRepository = referentielRepository;
    }

    @Override
    public Optional<Referentiel> findByLibelleAndDeletedFalse(String libelle) {
        return  referentielRepository.findByLibelleAndDeletedFalse(libelle);
    }

    @Override
    public List<Referentiel> findByEtat(Referentiel.Etat etat) {
        return  referentielRepository.findByEtat(etat); 
    }

    @Override
    public boolean existsByLibelle(String libelle) {
        return false;
    }





}
