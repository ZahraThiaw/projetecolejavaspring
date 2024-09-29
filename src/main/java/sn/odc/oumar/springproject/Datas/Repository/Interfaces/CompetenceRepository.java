package sn.odc.oumar.springproject.Datas.Repository.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.odc.oumar.springproject.Datas.Entity.Competence;

public interface CompetenceRepository extends BaseInterface<Competence,Long> {
    boolean existsByNom(String nom);
}
