package sn.odc.oumar.springproject.Services.Interfaces;

import sn.odc.oumar.springproject.Datas.Entity.Referentiel;

import java.util.List;
import java.util.Optional;

public interface ReferentielService extends BaseService<Referentiel, Long> {
    Optional<Referentiel> findByLibelleAndDeletedFalse(String libelle);
    List<Referentiel> findByEtat(Referentiel.Etat etat);
    boolean existsByLibelle(String libelle);
}
