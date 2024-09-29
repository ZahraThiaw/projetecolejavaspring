package sn.odc.oumar.springproject.Web.Dtos.Request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Set;

@Data
public class CompetenceDTO {

    @NotNull(message = "Nom de la compétence est obligatoire")
    @Size(min = 3, max = 50, message = "Le nom doit avoir entre 3 et 50 caractères")
    private String nom;

    @Size(max = 255, message = "La description ne peut pas dépasser 255 caractères")
    private String description;

    @NotNull(message = "La durée d'acquisition est obligatoire")
    @Min(value = 1, message = "La durée d'acquisition doit être au moins de 1 heure")
    @Max(value = 1000, message = "La durée d'acquisition ne peut pas dépasser 1000 heures")
    private Integer dureeAcquisition;

    @NotNull(message = "Le type de compétence est obligatoire")
    @Pattern(regexp = "^(BACKEND|FRONTEND)$", message = "Le type doit être 'Back-end' ou 'Front-End'")
    private String type; // Utilisation d'une chaîne pour simplifier

   // @NotNull(message = "Le référentiel associé est obligatoire")
   // private Long referentielId; // Représente l'ID du référentiel

    private Set<ModuleDTO> modules;


}
