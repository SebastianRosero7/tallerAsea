package co.edu.unicauca.asae.cleanarquitecture.aplicacion.input;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.EstadoEnum;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.ActualizarFormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADetailsDTORespuesta;

public interface GestionarFormatosACUIntPort {

    public FormatoADTORespuesta crear(FormatoADTOPeticion formato);
    public FormatoADTORespuesta actualizar(Long idFormato,ActualizarFormatoADTOPeticion formato);
    public Optional<FormatoADTORespuesta> findById(Long id);
    public Optional<Collection<FormatoADTORespuesta>> findByRangoFechas(LocalDate fechaInicio, LocalDate fechaFin);
    public Optional<Collection<FormatoADTORespuesta>> findAll();
    public Optional<FormatoADetailsDTORespuesta> listarFormatoADetalles(String tituloFormato);
    public boolean existeTituloFormato(String titulo); 
    public FormatoADTORespuesta agregarEstado(Long id,EstadoEnum estado);
    public List<FormatoADetailsDTORespuesta> formatosByDocente(String nombreDocente);
}
