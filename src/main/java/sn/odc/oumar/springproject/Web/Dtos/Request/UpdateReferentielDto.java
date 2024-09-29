package sn.odc.oumar.springproject.Web.Dtos.Request;



import lombok.Data;
import sn.odc.oumar.springproject.Datas.Entity.Referentiel;

import java.util.Set;

@Data
public class UpdateReferentielDto {
    private String libelle;
    private String description;
    private String photoCouverture;
    private Referentiel.Etat etat;
    private Set<UpdateCompetenceDto> competences;
}

