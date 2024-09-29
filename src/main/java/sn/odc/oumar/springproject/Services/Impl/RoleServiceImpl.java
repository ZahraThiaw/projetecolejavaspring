package sn.odc.oumar.springproject.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.odc.oumar.springproject.Datas.Entity.Role;
import sn.odc.oumar.springproject.Datas.Repository.Interfaces.BaseInterface;
import sn.odc.oumar.springproject.Datas.Repository.Interfaces.RoleRepository;
import sn.odc.oumar.springproject.Services.Interfaces.BaseService;
import sn.odc.oumar.springproject.Services.Interfaces.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,Long> implements RoleService {

    protected RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }



    @Override
    public Role findByLibelle(String libelle) {
        return  roleRepository.findByLibelle(libelle);
    }
}
