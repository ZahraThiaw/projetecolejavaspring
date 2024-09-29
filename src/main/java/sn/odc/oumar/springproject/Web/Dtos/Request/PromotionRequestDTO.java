package sn.odc.oumar.springproject.Web.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class PromotionRequestDTO {

    @NotBlank(message = "Le libellé ne peut pas être vide")
    @Size(max = 100, message = "Le libellé ne doit pas dépasser 100 caractères")
    private String libelle;

    @NotNull(message = "La date de début ne peut pas être nulle")
    private LocalDate dateDebut;

    @NotNull(message = "La date de fin ne peut pas être nulle")
    private LocalDate dateFin;

    @NotNull(message = "La durée réelle ne peut pas être nulle")
    private Integer dureeReel;

    private Set<Long> referentielIds; // Liste d'IDs pour les référentiels
}
