package sn.odc.oumar.springproject.Services.Interfaces;

import sn.odc.oumar.springproject.Datas.Entity.Role;

public interface RoleService extends BaseService<Role,Long>  {


    Role findByLibelle(String libelle);
}
