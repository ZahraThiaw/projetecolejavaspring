package sn.odc.oumar.springproject.Web.Dtos.Request;

import lombok.Data;

import java.util.Set;

@Data
public class ReferentielDTO {
    private String libelle;
    private String description;
    private String photoCouverture;
    private Set<CompetenceDTO> competences; // Liste de compétences
}
