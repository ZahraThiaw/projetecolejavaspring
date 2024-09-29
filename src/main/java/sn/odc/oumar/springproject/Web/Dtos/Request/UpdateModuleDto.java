package sn.odc.oumar.springproject.Web.Dtos.Request;

import lombok.Data;

@Data
public class UpdateModuleDto {
    private Long id; // ID du module pour modification
    private String nom;
    private String description;
    private Integer dureeAcquisition;
}
