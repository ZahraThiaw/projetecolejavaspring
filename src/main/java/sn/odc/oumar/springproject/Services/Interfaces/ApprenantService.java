package sn.odc.oumar.springproject.Services.Interfaces;

import org.springframework.web.multipart.MultipartFile;
import sn.odc.oumar.springproject.Datas.Entity.Apprenant;
import sn.odc.oumar.springproject.Web.Dtos.Request.ApprenantDTO;

public interface ApprenantService extends BaseService<Apprenant, Long> {
    public Apprenant createApprenant(ApprenantDTO apprenantDTO);
    public void insertMultipleApprenantsFromExcel(MultipartFile file);
}
