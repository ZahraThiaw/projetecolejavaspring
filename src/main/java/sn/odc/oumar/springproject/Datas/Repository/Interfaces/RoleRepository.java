package sn.odc.oumar.springproject.Datas.Repository.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.odc.oumar.springproject.Datas.Entity.Role;

public interface RoleRepository extends BaseInterface<Role,Long>  {

    Role findByLibelle(String libelle);
}
