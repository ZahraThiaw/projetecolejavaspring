package sn.odc.oumar.springproject.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.odc.oumar.springproject.Datas.listeners.CodeGeneratorListener;
import sn.odc.oumar.springproject.Datas.listeners.SoftDeleteListener;
import sn.odc.oumar.springproject.Datas.listeners.impl.CodeGeneratable;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "referentiels")
@EntityListeners({SoftDeleteListener.class, CodeGeneratorListener.class})
public class Referentiel extends BaseEntity implements  CodeGeneratable {

    public Referentiel(){
        super();
        this.competences = new HashSet<>(); // Initialisation de la liste des compétences par défaut à null au constructeur
    }


    @Column(unique = true, nullable = false)
    private String libelle;

    @Column(unique = true, nullable = false)
    private String code;

    private String description;

    private String photoCouverture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Etat etat = Etat.ACTIF;

    @ManyToMany(mappedBy = "referentiels")
    private Set<Promo> promos;

    @OneToMany(mappedBy = "referentiel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Competence> competences;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public enum Etat {
        ACTIF,
        CLOTURE,
        INACTIF
    }
}
