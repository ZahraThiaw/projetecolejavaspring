package sn.odc.oumar.springproject.Web.Controller.Impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.odc.oumar.springproject.Datas.Entity.Competence;
import sn.odc.oumar.springproject.Datas.Entity.Referentiel;
import sn.odc.oumar.springproject.Exceptions.ServiceException;
import sn.odc.oumar.springproject.Services.Interfaces.CompetenceService;
import sn.odc.oumar.springproject.Services.Interfaces.ReferentielService;
import sn.odc.oumar.springproject.Web.Dtos.Request.CompetenceRequestDTO;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/competences")
@Tag(name = "Competences", description = "API pour gérer les compétences")
public class CompetenceController {

    private final CompetenceService competenceService;
    private final ReferentielService referentielService;

    @Autowired
    public CompetenceController(CompetenceService competenceService, ReferentielService referentielService) {
        this.competenceService = competenceService;
        this.referentielService = referentielService;
    }

    @PostMapping
    public Competence createCompetence(@RequestBody @Valid CompetenceRequestDTO request) {
        // Création de la compétence
        Competence competence = new Competence();
        competence.setNom(request.getNom());
        competence.setDescription(request.getDescription());
        competence.setDureeAcquisition(request.getDureeAcquisition());
        competence.setType(Competence.Type.valueOf(request.getType()));

        // Vérification du référentiel
        Referentiel referentiel = referentielService.findById(request.getReferentielId())
                .orElseThrow(() -> new ServiceException("Référentiel non trouvé"));

        // Associer le référentiel à la compétence
        competence.setReferentiel(referentiel);

        // Sauvegarde de la compétence
        return competenceService.save(competence);
    }

    @GetMapping("/{id}")
    public Competence getCompetenceById(@PathVariable Long id) {
        return competenceService.findById(id)
                .orElseThrow(() -> new ServiceException("Compétence non trouvée"));
    }

    @DeleteMapping("/{id}")
    public void deleteCompetence(@PathVariable Long id) {
        Competence competence = competenceService.findById(id)
                .orElseThrow(() -> new ServiceException("Compétence non trouvée"));
        competenceService.deleteById(competence.getId());
    }

    @PutMapping("/{id}")
    public Competence updateCompetence(@PathVariable Long id, @RequestBody Competence competenceDetails) {
        Competence competence = competenceService.findById(id)
                .orElseThrow(() -> new ServiceException("Compétence non trouvée"));

        // Mettre à jour les champs
        competence.setNom(competenceDetails.getNom());
        competence.setDescription(competenceDetails.getDescription());
        competence.setDureeAcquisition(competenceDetails.getDureeAcquisition());
        competence.setType(competenceDetails.getType());

        // Sauvegarde de la compétence mise à jour
        return competenceService.save(competence);
    }
}
