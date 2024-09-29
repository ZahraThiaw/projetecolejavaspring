package sn.odc.oumar.springproject.Web.Dtos.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import sn.odc.oumar.springproject.Datas.Entity.Competence;

@Data
@AllArgsConstructor
@lombok.NoArgsConstructor(force = true)
public class CompetenceResponseDTO {
    private Long id;
    private String nom;
    private String description;
    private Integer dureeAcquisition;
    private String type;



    public CompetenceResponseDTO(Long id, String nom, String description, Integer dureeAcquisition, Competence.Type type) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dureeAcquisition = dureeAcquisition;
        this.type = String.valueOf(type);
    }
}
