package sn.odc.oumar.springproject.Web.Controller.Impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.odc.oumar.springproject.Datas.Entity.Competence;
import sn.odc.oumar.springproject.Datas.Entity.Module;
import sn.odc.oumar.springproject.Exceptions.ServiceException;
import sn.odc.oumar.springproject.Services.Interfaces.CompetenceService;
import sn.odc.oumar.springproject.Services.Interfaces.ModuleService;
import sn.odc.oumar.springproject.Web.Controller.BaseControllerImpl;
import sn.odc.oumar.springproject.Web.Controller.Interfaces.ModuleControllerInterface;
import sn.odc.oumar.springproject.Web.Dtos.Request.ModuleDTO;
import sn.odc.oumar.springproject.Web.Dtos.Request.ModuleRequestDTO;

@RestController
@RequestMapping("/api/v1/modules")
@Tag(name = "Modules", description = "API pour gérer les modules")
public class ModuleControllerImpl extends BaseControllerImpl<Module, ModuleDTO, Long> implements ModuleControllerInterface {

    private final ModuleService moduleService;
    private final CompetenceService competenceService;

    @Autowired
    public ModuleControllerImpl(ModuleService moduleService, CompetenceService competenceService) {
        super(moduleService); // Utiliser le constructeur parent avec le service de module
        this.moduleService = moduleService;
        this.competenceService = competenceService;
    }

    @PostMapping("/create")
    public Module create(@RequestBody @Valid ModuleRequestDTO moduleDTO) {
        // Vérification si le module existe déjà
        if (moduleService.moduleExists(moduleDTO.getNom())) {
            throw new ServiceException("Le module existe déjà");
        }

        // Vérification si la compétence associée existe
        Competence competence = competenceService.findById(moduleDTO.getCompetenceId())
                .orElseThrow(() -> new ServiceException("Compétence non trouvée"));

        // Création du module
        Module module = new Module();
        module.setNom(moduleDTO.getNom());
        module.setDescription(moduleDTO.getDescription());
        module.setDureeAcquisition(moduleDTO.getDureeAcquisition());
        module.setCompetence(competence); // Associer la compétence trouvée

        // Sauvegarder le module
        return moduleService.create(module);
    }

    @Override
    protected Module convertToEntity(ModuleDTO moduleDTO) {
        // Implémentation de la conversion ModuleDTO -> Module
        Module module = new Module();
        module.setNom(moduleDTO.getNom());
        module.setDescription(moduleDTO.getDescription());
        module.setDureeAcquisition(moduleDTO.getDureeAcquisition());
        return module;
    }

    @Override
    protected ModuleDTO convertToDto(Module entity) {
        // Implémentation de la conversion Module -> ModuleDTO
        ModuleDTO dto = new ModuleDTO();
        dto.setNom(entity.getNom());
        dto.setDescription(entity.getDescription());
        dto.setDureeAcquisition(entity.getDureeAcquisition());
        return dto;
    }
}
