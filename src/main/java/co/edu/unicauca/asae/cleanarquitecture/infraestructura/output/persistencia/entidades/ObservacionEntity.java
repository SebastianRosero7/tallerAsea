package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "observaciones")
@Getter
@Setter
public class ObservacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObservacion;

    @Column(name = "observacion")
    private String observcaion;

    @Column(name = "fecha_registro_observacion")
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idfkEvaluacion",nullable = false)
    private EvaluacionEntity objEvaluacion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "observacion_docentes",
            joinColumns = @JoinColumn(name = "idfkObservacion"),
            inverseJoinColumns = @JoinColumn(name = "idfkDocente")
    )
    private List<DocenteEntity> docentes = new ArrayList<>();

}
