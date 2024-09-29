package sn.odc.oumar.springproject.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;
import sn.odc.oumar.springproject.Datas.listeners.impl.SoftDeletable;
import sn.odc.oumar.springproject.Datas.listeners.SoftDeleteListener;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "promos")
@Data
@EntityListeners(SoftDeleteListener.class)
public class Promo  extends BaseEntity{



    @Column(unique = true, nullable = false)
    private String libelle;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private int dureeReel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.ACTIF;

    @ManyToMany // Relation ManyToMany avec Referentiel
    @JoinTable(
            name = "promo_referentiels", // Nom de la table de jointure
            joinColumns = @JoinColumn(name = "promo_id"), // Colonne pour Promotion
            inverseJoinColumns = @JoinColumn(name = "referentiel_id") // Colonne pour Referentiel
    )
    private Set<Referentiel> referentiels;

    public Promo() {
        super();
        this.referentiels = new HashSet<>();
    }


    public enum Etat {
        ACTIF,
        CLOTURE,
        INACTIF
    }
}
