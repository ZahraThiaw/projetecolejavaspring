package sn.odc.oumar.springproject.Datas.Repository.Interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.odc.oumar.springproject.Datas.Entity.Competence;
import sn.odc.oumar.springproject.Datas.Entity.Referentiel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReferentielRepository extends BaseInterface<Referentiel, Long> {
    boolean existsByLibelle(String libelle);
    List<Referentiel> findByCompetencesContaining(Competence competence);
    public Optional<Referentiel> findByLibelleAndDeletedFalse(String libelle);
    List<Referentiel> findByEtat(@Param("etat") Referentiel.Etat etat);
    // Récupérer un referentiel non supprimé par ID

}
