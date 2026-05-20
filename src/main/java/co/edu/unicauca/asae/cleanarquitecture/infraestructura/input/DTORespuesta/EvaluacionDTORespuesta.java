package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluacionDTORespuesta {
    private int idEvaluacion;
    private String concepto;
    private Date fechaRegistroConcepto;
    private String nombreCoordinador;

}
