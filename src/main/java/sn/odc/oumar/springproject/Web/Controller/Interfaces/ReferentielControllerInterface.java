package sn.odc.oumar.springproject.Web.Controller.Interfaces;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import sn.odc.oumar.springproject.Datas.Entity.Referentiel;
import sn.odc.oumar.springproject.Datas.Entity.Role;
import sn.odc.oumar.springproject.Web.Dtos.Request.ReferentielDTO;
import sn.odc.oumar.springproject.Web.Dtos.Response.BaseResponse;

public interface ReferentielControllerInterface  {
    public ResponseEntity<BaseResponse<Referentiel>> createReferentiel(@Valid @RequestBody ReferentielDTO referentielRequestDTO) ;


    }
