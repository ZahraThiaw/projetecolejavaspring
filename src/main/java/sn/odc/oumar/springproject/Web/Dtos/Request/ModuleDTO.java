package sn.odc.oumar.springproject.Web.Dtos.Request;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
public class ModuleDTO {

    private Long id; // Identifiant du module

    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
    private String nom; // Nom du module

    private String description; // Description du module

    @NotNull(message = "La durée d'acquisition ne peut pas être nulle")
    private Integer dureeAcquisition; // Durée d'acquisition du module

}
