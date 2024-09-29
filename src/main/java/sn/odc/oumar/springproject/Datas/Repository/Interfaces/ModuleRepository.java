package sn.odc.oumar.springproject.Datas.Repository.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.odc.oumar.springproject.Datas.Entity.Module;

public interface ModuleRepository extends BaseInterface<Module,Long> {
    boolean existsByNom(String nom);
    public Module findByNom(String nom);

}
