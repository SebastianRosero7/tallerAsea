package co.edu.unicauca.asae.cleanarquitecture.aplicacion.input;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoA;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta.FormatoADTORespuesta;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface GestionarFormatosACUIntPort {

    public FormatoADTORespuesta crear(FormatoADTOPeticion formato);
    public Optional<FormatoADTORespuesta> findById(Long id);
    public Optional<Collection<FormatoADTORespuesta>> findByRangoFechas(LocalDate fechaInicio, LocalDate fechaFin);
    public Optional<Collection<FormatoADTORespuesta>> findAll();
}
