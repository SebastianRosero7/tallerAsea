package co.edu.unicauca.asae.cleanarquitecture.dominio.modelo;

import java.util.List;

public class Docente {
    private int idDocente;

    private String nombresDocente;

    private String apellidosDocente;

    private String nombreGrupo;

    private String correo;

    private List<Historico> historicos;

    private List<FormatoA> formatosA;

    public Docente() {
    }

    public Docente(int idDocente, String nombresDocente,
                String apellidosDocente, String nombreGrupo,
                String correo, List<Historico> historicos,
                List<FormatoA> formatosA) {
        this.idDocente = idDocente;
        this.nombresDocente = nombresDocente;
        this.apellidosDocente = apellidosDocente;
        this.nombreGrupo = nombreGrupo;
        this.correo = correo;
        this.historicos = historicos;
        this.formatosA = formatosA;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombresDocente() {
        return nombresDocente;
    }

    public void setNombresDocente(String nombresDocente) {
        this.nombresDocente = nombresDocente;
    }

    public String getApellidosDocente() {
        return apellidosDocente;
    }

    public void setApellidosDocente(String apellidosDocente) {
        this.apellidosDocente = apellidosDocente;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }

    public List<FormatoA> getFormatosA() {
        return formatosA;
    }

    public void setFormatosA(List<FormatoA> formatosA) {
        this.formatosA = formatosA;
    }
}
