package sn.odc.oumar.springproject.Datas.Repository.Interfaces;

import sn.odc.oumar.springproject.Datas.Entity.Promo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromoRepository extends BaseInterface<Promo,Long> {
    boolean existsByLibelle(String  libelle);
    List<Promo> findByDeletedFalse();
}
