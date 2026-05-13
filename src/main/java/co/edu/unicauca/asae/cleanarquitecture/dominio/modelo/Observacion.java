package co.edu.unicauca.asae.cleanarquitecture.dominio.modelo;

import java.util.Date;
import java.util.List;

public class Observacion {
    private int idObservacion;

    private String observcaion;

    private Date fechaRegistro;

    private Evaluacion objEvaluacion;

    private List<Docente> docentes;

    public Observacion(int idObservacion, String observcaion, Date fechaRegistro,
                   Evaluacion objEvaluacion, List<Docente> docentes) {
    this.idObservacion = idObservacion;
    this.observcaion = observcaion;
    this.fechaRegistro = fechaRegistro;
    this.objEvaluacion = objEvaluacion;
    this.docentes = docentes;
    }

    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    public String getObservcaion() {
        return observcaion;
    }

    public void setObservcaion(String observcaion) {
        this.observcaion = observcaion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Evaluacion getObjEvaluacion() {
        return objEvaluacion;
    }

    public void setObjEvaluacion(Evaluacion objEvaluacion) {
        this.objEvaluacion = objEvaluacion;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

}
