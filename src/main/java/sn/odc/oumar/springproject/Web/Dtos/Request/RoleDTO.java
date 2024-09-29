package sn.odc.oumar.springproject.Web.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import sn.odc.oumar.springproject.Datas.Entity.BaseEntity;

@Getter
@Setter
public class RoleDTO extends BaseEntity {
    @NotBlank(message = "Le champ 'libelle' ne doit pas être vide.")
    private String libelle;
}
