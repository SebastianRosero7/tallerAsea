package co.edu.unicauca.asae.cleanarquitecture.dominio.modelo;

import java.util.List;

public class FormatoTI extends FormatoA {

    private String nombreEstudiante1;
    
    private String nombreEstudiante2;

    public FormatoTI(Long idFormatoA, String titulo, String objetivoGeneral,
                 String objetivosEspecificos, Estado objEstado,
                 Docente objDocente, List<Evaluacion> evaluaciones,
                 String nombreEstudiante1, String nombreEstudiante2) {

    super(idFormatoA, titulo, objetivoGeneral, objetivosEspecificos,
          objEstado, objDocente, evaluaciones);

    this.nombreEstudiante1 = nombreEstudiante1;
    this.nombreEstudiante2 = nombreEstudiante2;
    }

    public String getNombreEstudiante1() {
        return nombreEstudiante1;
    }

    public void setNombreEstudiante1(String nombreEstudiante1) {
        this.nombreEstudiante1 = nombreEstudiante1;
    }

    public String getNombreEstudiante2() {
        return nombreEstudiante2;
    }

    public void setNombreEstudiante2(String nombreEstudiante2) {
        this.nombreEstudiante2 = nombreEstudiante2;
    }

}
