package co.edu.unicauca.asae.cleanarquitecture.aplicacion.input;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADTORespuesta;

import java.util.Collection;

public interface GestionarDocentesCUIntPort {
    public DocenteDTORespuesta crear(DocenteDTOPeticion docente);
    public Collection<DocenteDTORespuesta> listarDocentes(String nombreGrupo, String patron, String nombreDocente, String nombreRol);
    public DocenteDTORespuesta findById(Long id);
}
