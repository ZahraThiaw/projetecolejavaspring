package sn.odc.oumar.springproject.Datas.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity
@Table(name = "notes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note extends BaseEntity {

    @Column(nullable = false)
    private Double note;

    // Relation ManyToOne avec Module
    @ManyToOne
    @JoinColumn(name = "module_id", referencedColumnName = "id", nullable = false)
    private Module module;

    // Relation ManyToOne avec Apprenant
    @ManyToOne
    @JoinColumn(name = "apprenant_id", referencedColumnName = "id", nullable = false)
    private Apprenant apprenant;
}
