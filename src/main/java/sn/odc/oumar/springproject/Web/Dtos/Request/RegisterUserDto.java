package sn.odc.oumar.springproject.Web.Dtos.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String password;
    private String telephone;
    private Long role_id;   // Nom du rôle associé
    private String fonction; // Nom de la fonction associée
    private String photo;   // URL ou chemin de la photo de l'utilisateur
}



