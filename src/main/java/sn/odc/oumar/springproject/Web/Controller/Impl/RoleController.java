package sn.odc.oumar.springproject.Web.Controller.Impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sn.odc.oumar.springproject.Datas.Entity.Role;
import sn.odc.oumar.springproject.Exceptions.ControllerException;
import sn.odc.oumar.springproject.Services.Interfaces.RoleService;
import sn.odc.oumar.springproject.Web.Controller.BaseControllerImpl;
import sn.odc.oumar.springproject.Web.Controller.Interfaces.RoleControllerInterface;
import sn.odc.oumar.springproject.Web.Dtos.Request.RoleDTO;
import sn.odc.oumar.springproject.Web.Dtos.Response.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@Tag(name = "Roles", description = "API pour gérer les rôles")
public class RoleController extends BaseControllerImpl<Role, RoleDTO, Long> implements RoleControllerInterface {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        super(roleService);
        this.roleService = roleService;
    }

    @Override
    protected Role convertToEntity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setLibelle(roleDTO.getLibelle());
        return role;
    }

    @Override
    protected RoleDTO convertToDto(Role entity) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(entity.getId());  // Ajoute l'ID pour le DTO
        roleDTO.setLibelle(entity.getLibelle());
        return roleDTO;
    }
    @GetMapping("/libelle")

    public Role findByLibelle(@RequestParam(required = false) String libelle) {
        // Vérification si le libellé est fourni
        if (libelle == null || libelle.isEmpty()) {
            throw new ControllerException("Le libellé est obligatoire");
        }

        // Rechercher le rôle par libellé
        Role role = roleService.findByLibelle(libelle);

        if (role == null) {
            throw new ControllerException("Rôle non trouvé");
        }

        // Retourner le rôle trouvé
        return role;
    }

}
