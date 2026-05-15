package co.edu.unicauca.asae.cleanarquitecture.aplicacion.input;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta.DocenteDTORespuesta;

import java.util.Collection;

public interface GestionarDocentesCUIntPort {
    public DocenteDTORespuesta crear(DocenteDTOPeticion docente);
    public Collection<DocenteDTORespuesta> listarDocentes(String nombreGrupo, String patron);
    public DocenteDTORespuesta findById(Long id);
}
