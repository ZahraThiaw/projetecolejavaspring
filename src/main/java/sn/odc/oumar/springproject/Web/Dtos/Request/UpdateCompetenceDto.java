package sn.odc.oumar.springproject.Web.Dtos.Request;

import lombok.Data;
import sn.odc.oumar.springproject.Datas.Entity.Competence;

import java.util.Set;

@Data
public class UpdateCompetenceDto {
    private Long id; // ID de la compétence pour modification
    private String nom;
    private String description;
    private Integer dureeAcquisition;
    private Competence.Type type;
    private Set<UpdateModuleDto> modules;
}
