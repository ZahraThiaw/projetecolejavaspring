package sn.odc.oumar.springproject.Datas.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "competences")
public class Competence extends BaseEntity{

    public Competence(){
        super();
        this.modules = new HashSet<>();  // Initialisation des modules par défaut à null au constructeur
    }


    @Column(nullable = false, unique = true)
    private String nom;

    private String description;

    private Integer dureeAcquisition; // Durée en heures ou jours, par exemple

    @Enumerated(EnumType.STRING)
    private Type type = Type.BACKEND; // Enum pour le type de compétence

    @ManyToOne
    @JoinColumn(name = "referentiel_id") // Nom de la colonne de clé étrangère
    @JsonIgnore
    private Referentiel referentiel; // Référence vers le referentiel

    @OneToMany(mappedBy = "competence", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Module> modules;

    public enum Type {
        BACKEND,
        FRONTEND,

    }

}
