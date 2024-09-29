package sn.odc.oumar.springproject.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.odc.oumar.springproject.Datas.Repository.Interfaces.ModuleRepository;
import sn.odc.oumar.springproject.Services.Interfaces.ModuleService;
import sn.odc.oumar.springproject.Datas.Entity.Module;


import java.util.Optional;

@Service
public class ModuleServiceImpl extends BaseServiceImpl<Module,Long> implements ModuleService {

    private static ModuleRepository moduleRepository;

    @Autowired
    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        super(moduleRepository);
        ModuleServiceImpl.moduleRepository = moduleRepository;
    }


    @Override
    public boolean moduleExists(String libelle) {
        return  moduleRepository.existsByNom(libelle);
    }
}
