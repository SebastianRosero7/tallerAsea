package co.edu.unicauca.asae.cleanarquitecture.aplicacion.input;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.ObservacionDTORespuesta;

public interface GestionarObservacionesCUIntPort {

    public ObservacionDTORespuesta crear(ObservacionDTOPeticion dtoObservacion);

}
