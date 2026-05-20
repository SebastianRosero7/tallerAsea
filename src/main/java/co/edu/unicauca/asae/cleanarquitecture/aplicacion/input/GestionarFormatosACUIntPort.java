package co.edu.unicauca.asae.cleanarquitecture.aplicacion.input;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADetailsDTORespuesta;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface GestionarFormatosACUIntPort {

    public FormatoADTORespuesta crear(FormatoADTOPeticion formato);
    public Optional<FormatoADTORespuesta> findById(Long id);
    public Optional<Collection<FormatoADTORespuesta>> findByRangoFechas(LocalDate fechaInicio, LocalDate fechaFin);
    public Optional<Collection<FormatoADTORespuesta>> findAll();
    public Optional<FormatoADetailsDTORespuesta> listarFormatoADetalles(String tituloFormato);
}
