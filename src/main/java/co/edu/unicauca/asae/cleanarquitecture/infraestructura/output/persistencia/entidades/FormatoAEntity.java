package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "formatos_a")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class FormatoAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormatoA;

    @Column(length = 100, unique = true)
    private String titulo;

    @Column(name = "objetivo_general")
    private String objetivoGeneral;

    @Column(name = "objetivos_especificos")
    private String objetivosEspecificos;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, mappedBy = "objFormatoA")
    private EstadoEntity objEstado;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idfkDocente",nullable = false)
    private DocenteEntity objDocente;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objFormatoA")
    private Set<EvaluacionEntity> evaluaciones;
}
