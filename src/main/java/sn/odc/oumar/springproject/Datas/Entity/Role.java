package sn.odc.oumar.springproject.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends BaseEntity {
    public  Role(){
         super();  // Appel du constructeur de la superclasse (BaseEntity) au constructeur de la classe Role.

    }

    @Column(unique = true, nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;


}
