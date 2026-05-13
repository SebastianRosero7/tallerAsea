package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "evaluaciones")
@Data
public class EvaluacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvaluacion;

    @Column(length = 255)
    private String concepto;

    @Column(name = "fecha_registro_concepto")
    private Date fechaRegistroConcepto;

    @Column(name = "nombre_cordinador",length = 100)
    private String nombreCordinador;

    @ManyToOne
    @JoinColumn(name = "idfkFormatoA",nullable = false)
    private FormatoAEntity objFormatoA;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objEvaluacion")
    private List<ObservacionEntity> observaciones;

}
