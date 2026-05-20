package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormatoADetailsDTORespuesta {
    private String titulo;
    private List<EvaluacioneQuery1DTORespuesta> evaluaciones = new ArrayList<>();

}
