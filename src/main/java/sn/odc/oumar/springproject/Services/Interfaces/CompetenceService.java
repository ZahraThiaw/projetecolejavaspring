package sn.odc.oumar.springproject.Services.Interfaces;

import sn.odc.oumar.springproject.Datas.Entity.Competence;

import java.util.Optional;

public interface CompetenceService {
     public Competence save(Competence entity);
     public Optional<Competence> findById(Long id);
     public Iterable<Competence> findAll();
     public void deleteById(Long id);
     public Competence update(Competence entity);
     public boolean existsByNom(String nom);
     void deleteById(Competence competence);
}
