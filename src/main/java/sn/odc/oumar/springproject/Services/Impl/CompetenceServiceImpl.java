package sn.odc.oumar.springproject.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.odc.oumar.springproject.Datas.Entity.Competence;
import sn.odc.oumar.springproject.Datas.Repository.Interfaces.CompetenceRepository;
import sn.odc.oumar.springproject.Services.Interfaces.CompetenceService;

import java.util.Optional;

@Service
public class CompetenceServiceImpl implements CompetenceService {
    private static CompetenceRepository competenceRepository;

    @Autowired
    public CompetenceServiceImpl(CompetenceRepository competenceRepository) {
        CompetenceServiceImpl.competenceRepository = competenceRepository;
    }
    @Override
    public Competence save(Competence entity) {
        return competenceRepository.save(entity);
    }

    @Override
    public Optional<Competence> findById(Long id) {
        return competenceRepository.findById(id);
    }

    @Override
    public Iterable<Competence> findAll() {
        return competenceRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        competenceRepository.deleteById(id);
    }

    @Override
    public Competence update(Competence entity) {
        return  competenceRepository.save(entity);
    }

    @Override
    public boolean existsByNom(String nom) {
        return competenceRepository.existsByNom(nom);
    }

    @Override
    public void deleteById(Competence competence) {
    competenceRepository.delete(competence);
    
    }
}
