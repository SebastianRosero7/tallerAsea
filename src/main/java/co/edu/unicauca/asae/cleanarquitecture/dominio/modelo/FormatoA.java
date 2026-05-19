package co.edu.unicauca.asae.cleanarquitecture.dominio.modelo;

import java.util.List;

public class FormatoA {

    private Long idFormatoA;

    private String titulo;

    private String objetivoGeneral;

    private String objetivosEspecificos;

    private Estado objEstado;

    private Docente objDocente;

    private List<Evaluacion> evaluaciones;

    public FormatoA(Long idFormatoA, String titulo, String objetivoGeneral,
                        String objetivosEspecificos, Estado objEstado,
                        Docente objDocente, List<Evaluacion> evaluaciones) {
        this.idFormatoA = idFormatoA;
        this.titulo = titulo;
        this.objetivoGeneral = objetivoGeneral;
        this.objetivosEspecificos = objetivosEspecificos;
        this.objEstado = objEstado;
        this.objDocente = objDocente;
        this.evaluaciones = evaluaciones;
    }

    public Long getIdFormatoA() {
    return idFormatoA;
    }

    public void setIdFormatoA(Long idFormatoA) {
        this.idFormatoA = idFormatoA;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public String getObjetivosEspecificos() {
        return objetivosEspecificos;
    }

    public void setObjetivosEspecificos(String objetivosEspecificos) {
        this.objetivosEspecificos = objetivosEspecificos;
    }

    public Estado getObjEstado() {
        return objEstado;
    }

    public void setObjEstado(Estado objEstado) {
        this.objEstado = objEstado;
    }

    public Docente getObjDocente() {
        return objDocente;
    }

    public void setObjDocente(Docente objDocente) {
        this.objDocente = objDocente;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

}
