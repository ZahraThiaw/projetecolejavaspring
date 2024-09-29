package sn.odc.oumar.springproject.Services.Interfaces;

import sn.odc.oumar.springproject.Datas.Entity.Module;

import java.util.Optional;

public interface ModuleService extends BaseService<Module,Long> {
    public boolean moduleExists(String libelle);
}
