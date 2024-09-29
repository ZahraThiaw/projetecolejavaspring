package sn.odc.oumar.springproject.Web.Controller.Interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import sn.odc.oumar.springproject.Datas.Entity.Apprenant;
import sn.odc.oumar.springproject.Web.Dtos.Request.ApprenantDTO;

public interface ApprenantControllerInterface  {
    public ResponseEntity<Apprenant> ajouterApprenant(ApprenantDTO apprenant);
    public void isertMultiple (MultipartFile file);

}
