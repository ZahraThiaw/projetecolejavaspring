package sn.odc.oumar.springproject.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString
@Table(name = "apprenants")
@Inheritance(strategy = InheritanceType.JOINED) // Utilisation de la stratégie de héritage JOINED
@DiscriminatorColumn(name = "etat_apprenant") // Utilisation d'une colonne de discriminant pour la stratégie de héritage
@DiscriminatorValue("apprenant") // Valeur du discriminant pour les instances de la classe Appren
public class Apprenant extends BaseEntity{


    private String nom_tuteur;
    private String prenom_tuteur;
    private String contact_tuteur;
    private String cni_file;
    private String extrait_file;
    private String diplome_file;
    private String casier_file;
    private String photo_couverture;


    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private User user;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.ACTIF;



    @ManyToOne
    @JoinColumn(name = "promo_referentiel_id", nullable = false)
    private PromoReferentiel promoReferentiel;

    public enum Etat {
            ACTIF,
            INACTIF,
            BLOQUE
    }
}