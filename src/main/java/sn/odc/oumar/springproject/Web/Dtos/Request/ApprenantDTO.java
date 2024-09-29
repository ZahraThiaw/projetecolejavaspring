package sn.odc.oumar.springproject.Web.Dtos.Request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@lombok.experimental.SuperBuilder
@lombok.ToString(callSuper = true)
public class ApprenantDTO {
    // Champs Apprenant
    @NotBlank(message = "Le nom du tuteur est obligatoire.")
    private String nomTuteur;

    @NotBlank(message = "Le prénom du tuteur est obligatoire.")
    private String prenomTuteur;

    @NotBlank(message = "Le contact du tuteur est obligatoire.")
    private String contactTuteur;

    private String cniFile;
    private String extraitFile;
    private String diplomeFile;
    private String casierFile;
    private String photoCouverture;

    @NotNull(message = "L'état est obligatoire.")
    private String etat; // ACTIF, INACTIF, BLOQUE

    @NotNull(message = "Le promoReferentielId est obligatoire.")
    private Long promoReferentielId;

    // Champs User imbriqués
    @NotNull(message = "Les informations de l'utilisateur sont obligatoires.")
    private UserCreationDTO user;

    public ApprenantDTO() {

    }
}
