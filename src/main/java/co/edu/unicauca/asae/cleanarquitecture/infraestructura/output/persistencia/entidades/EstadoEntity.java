package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estados")
@Getter
@Setter
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstado;

    @Column(name = "estado_actual", length = 50)
    private String estadoActual ="En formulacion";

    @Column(name = "fecha_registro_estado")
    private Date fechaRegistroEstado = new Date();

    @OneToOne
    @JoinColumn(name = "idfkFormatoA", unique = true)
    private FormatoAEntity objFormatoA;
     
}
