package sn.odc.oumar.springproject.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fonctions")
@Data
public class Fonction extends  BaseEntity {

    private String libelle;

    @Column(length = 500)
    private String description;
}
