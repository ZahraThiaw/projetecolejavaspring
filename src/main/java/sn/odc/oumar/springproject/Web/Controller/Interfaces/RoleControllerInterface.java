package sn.odc.oumar.springproject.Web.Controller.Interfaces;

import org.springframework.http.ResponseEntity;
import sn.odc.oumar.springproject.Datas.Entity.Referentiel;
import sn.odc.oumar.springproject.Datas.Entity.Role;
import sn.odc.oumar.springproject.Web.Dtos.Request.RoleDTO;
import sn.odc.oumar.springproject.Web.Dtos.Response.BaseResponse;

public interface RoleControllerInterface {
    Role findByLibelle(String libelle);
}
