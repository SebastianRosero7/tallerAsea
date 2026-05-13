package co.edu.unicauca.asae.cleanarquitecture.dominio.modelo;

import java.util.Date;

public class Historico {
    private int idHistorico;
    private int activo;
    private Date fechaInicio;
    private Date fechaFin;
    private Rol objRol;
    private Docente objDocente;
    public Historico() {
}

public Historico(int idHistorico, int activo, Date fechaInicio,
                 Date fechaFin, Rol objRol,
                 Docente objDocente) {
    this.idHistorico = idHistorico;
    this.activo = activo;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.objRol = objRol;
    this.objDocente = objDocente;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Rol getObjRol() {
        return objRol;
    }

    public void setObjRol(Rol objRol) {
        this.objRol = objRol;
    }

    public Docente getObjDocente() {
        return objDocente;
    }

    public void setObjDocente(Docente objDocente) {
        this.objDocente = objDocente;
    }
}
