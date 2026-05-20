package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluacionesDTORespuesta {

    private String concepto;

    private Date fechaRegistroConcepto;

    private List<ObservacionDTORespuesta> observaciones = new ArrayList<>();

}
