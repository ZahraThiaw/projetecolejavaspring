package sn.odc.oumar.springproject.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "modules")
@Data
public class Module extends BaseEntity{

    public Module(){
        super();
        this.competence = new Competence();  // Initialisation de la compétence par défaut à null au constructeur
    }



    @Column(nullable = false, unique = true)
    private String nom;

    private String description;

    @Column(nullable = false )
    private Integer dureeAcquisition;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "competence_id") // Nom de la colonne de clé étrangère
    private Competence competence; // Référence vers la compétence

    // Relation OneToMany avec Note
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();
}
