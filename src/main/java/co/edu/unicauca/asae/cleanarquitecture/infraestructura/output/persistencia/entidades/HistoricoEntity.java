package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "historicos")
@Getter
@Setter
public class HistoricoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorico;
    private int activo;
    private Date fechaInicio;
    private Date fechaFin;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfkRol",nullable = false)
    private RolEntity objRol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfkDocente",nullable = false)
    private DocenteEntity objDocente;
}
