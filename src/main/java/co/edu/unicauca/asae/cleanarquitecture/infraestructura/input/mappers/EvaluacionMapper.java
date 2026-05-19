package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.EvaluacionDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import org.springframework.stereotype.Component;

@Component
public class EvaluacionMapper {
    public EvaluacionDTORespuesta toEvaluacionDTORespuesta(EvaluacionEntity entity) {
        EvaluacionDTORespuesta dto = new EvaluacionDTORespuesta();
        dto.setIdEvaluacion(entity.getIdEvaluacion());
        dto.setConcepto(entity.getConcepto());
        dto.setFechaRegistroConcepto(entity.getFechaRegistroConcepto() == null ? null : entity.getFechaRegistroConcepto());
        dto.setNombreCoordinador(entity.getNombreCordinador());
        return dto;
    }
}
