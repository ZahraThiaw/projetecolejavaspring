package sn.odc.oumar.springproject.Web.Controller.Impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sn.odc.oumar.springproject.Datas.Entity.Apprenant;
import sn.odc.oumar.springproject.Services.Interfaces.ApprenantService;
import sn.odc.oumar.springproject.Web.Controller.BaseControllerImpl;
import sn.odc.oumar.springproject.Web.Controller.Interfaces.ApprenantControllerInterface;
import sn.odc.oumar.springproject.Web.Dtos.Request.ApprenantDTO;

@RequestMapping("/api/v1/apprenants")
@RestController
@Tag(name = "apprenants", description = "API pour gérer les appreants")
public class ApprenantControllerImpl extends BaseControllerImpl<Apprenant,ApprenantDTO,Long>  implements ApprenantControllerInterface {
    protected ApprenantService service;
    @Autowired
    public ApprenantControllerImpl(ApprenantService service) {
        super( service);
        this.service = service;
    }

   // @Override
    protected Apprenant convertToEntity(ApprenantDTO apprenantDTO) {
        return null;
    }

  //  @Override
    protected ApprenantDTO convertToDto(Apprenant entity) {
        return null;
    }

    @Override
    @PostMapping(value="/create",produces="application/json")
    public ResponseEntity<Apprenant> ajouterApprenant(@RequestBody @Valid ApprenantDTO apprenant) {
            System.out.println("ok");
            Apprenant apprenantEntity = convertToEntity(apprenant);
            return ResponseEntity.ok(service.createApprenant(apprenant));

    }

    @PostMapping(value="/import")
    public void isertMultiple (MultipartFile file) {
        // Implementation du chargement et insertion des apprenants
         service.insertMultipleApprenantsFromExcel(file);
    }
}
