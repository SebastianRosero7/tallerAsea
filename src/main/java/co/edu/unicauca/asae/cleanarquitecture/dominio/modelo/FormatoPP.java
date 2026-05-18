package co.edu.unicauca.asae.cleanarquitecture.dominio.modelo;

import java.util.List;

public class FormatoPP extends FormatoA{

    private String nombreAsesor;

    private String nombreEstudiante1;
    
    private String ruta_carta_aceptacion;

    public FormatoPP(Long idFormatoA, String titulo, String objetivoGeneral,
                 String objetivosEspecificos, Estado objEstado,
                 Docente objDocente, List<Evaluacion> evaluaciones,
                 String nombreAsesor, String nombreEstudiante1,
                 String ruta_carta_aceptacion) {

    super(idFormatoA, titulo, objetivoGeneral, objetivosEspecificos,
          objEstado, objDocente, evaluaciones);

    this.nombreAsesor = nombreAsesor;
    this.nombreEstudiante1 = nombreEstudiante1;
    this.ruta_carta_aceptacion = ruta_carta_aceptacion;
    }

    public String getNombreAsesor() {
        return nombreAsesor;
    }

    public void setNombreAsesor(String nombreAsesor) {
        this.nombreAsesor = nombreAsesor;
    }

    public String getNombreEstudiante1() {
        return nombreEstudiante1;
    }

    public void setNombreEstudiante1(String nombreEstudiante1) {
        this.nombreEstudiante1 = nombreEstudiante1;
    }

    public String getRuta_carta_aceptacion() {
        return ruta_carta_aceptacion;
    }

    public void setRuta_carta_aceptacion(String ruta_carta_aceptacion) {
        this.ruta_carta_aceptacion = ruta_carta_aceptacion;
    }

}
