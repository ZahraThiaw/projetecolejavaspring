package sn.odc.oumar.springproject.Web.Dtos.Response;

import sn.odc.oumar.springproject.Datas.Entity.Referentiel;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class PromoDTO {
    private String libelle;
    private LocalDate dateDebut;
    private Integer dureeReel;
    private Set<Referentiel> referentielsActifs; // Ou une liste d'IDs

}
