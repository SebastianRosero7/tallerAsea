package co.edu.unicauca.asae.cleanarquitecture.dominio.modelo;



import java.util.Date;
import java.util.List;

public class Evaluacion {
    private int idEvaluacion;

    private String concepto;

    private Date fechaRegistroConcepto;

    private String nombreCordinador;

    private List<Observacion> observaciones;

    public Evaluacion() {
    }

    public Evaluacion(int idEvaluacion, String concepto,
                    Date fechaRegistroConcepto, String nombreCordinador,
                    List<Observacion> observaciones) {
        this.idEvaluacion = idEvaluacion;
        this.concepto = concepto;
        this.fechaRegistroConcepto = fechaRegistroConcepto;
        this.nombreCordinador = nombreCordinador;
        this.observaciones = observaciones;
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFechaRegistroConcepto() {
        return fechaRegistroConcepto;
    }

    public void setFechaRegistroConcepto(Date fechaRegistroConcepto) {
        this.fechaRegistroConcepto = fechaRegistroConcepto;
    }

    public String getNombreCordinador() {
        return nombreCordinador;
    }

    public void setNombreCordinador(String nombreCordinador) {
        this.nombreCordinador = nombreCordinador;
    }

    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }

}