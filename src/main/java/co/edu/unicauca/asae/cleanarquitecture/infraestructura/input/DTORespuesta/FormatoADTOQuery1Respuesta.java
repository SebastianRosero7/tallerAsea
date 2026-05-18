package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormatoADTOQuery1Respuesta {
    FormatoADTORespuesta formatoA;
    HistoricoDTORespuesta historico;
    List<ObservacionDTORespuesta> observaciones;
    DocenteDTORespuesta docente;
}
