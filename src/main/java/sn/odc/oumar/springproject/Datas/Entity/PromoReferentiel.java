package sn.odc.oumar.springproject.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "promo_referentiels")
public class PromoReferentiel extends BaseEntity implements Serializable {

    public PromoReferentiel() {
        super(); // Initialisation des champs 'createdAt' et 'deleted' via BaseEntity
    }

    @ManyToOne
    @JoinColumn(name = "promo_id", nullable = false)
    private Promo promo;

    @ManyToOne
    @JoinColumn(name = "referentiel_id", nullable = false)
    private Referentiel referentiel;

    @OneToMany(mappedBy = "promoReferentiel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Apprenant> apprenants;

}
