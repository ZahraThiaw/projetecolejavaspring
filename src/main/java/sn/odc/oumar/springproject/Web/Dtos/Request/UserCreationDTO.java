package sn.odc.oumar.springproject.Web.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class UserCreationDTO {
    @NotBlank(message = "Le nom est obligatoire.")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire.")
    private String prenom;

    @NotBlank(message = "L'adresse est obligatoire.")
    private String adresse;


    @NotBlank(message = "Le mot de passe est obligatoire.")
    private String password;
    private String photo;

    @NotBlank(message = "Le téléphone est obligatoire.")
    private String telephone;

    private String email;
    private Long role_id;
}
