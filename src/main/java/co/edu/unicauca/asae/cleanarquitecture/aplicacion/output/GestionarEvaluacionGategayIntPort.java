package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;

public interface GestionarEvaluacionGategayIntPort {

    public EvaluacionEntity guardar(EvaluacionEntity evaluacionEntity);
}
package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.EvaluacionDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface GestionarEvaluacionGategayIntPort {

    public EvaluacionEntity guardar(EvaluacionEntity evaluacionEntity);
    public List<EvaluacionDTORespuesta> buscarEvaluaciones(@Param("fechaInicio") Date fechaInicio, Date fechaFin, String nombreDocente);
}
