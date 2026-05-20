package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import java.util.List;
import java.util.Optional;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface GestionarDocentesGatewayIntPort {

    DocenteEntity guardar(DocenteEntity docente);
    List<DocenteEntity> listarDocenteByGrupo(String nombreGrupo, String patron);
    List<DocenteEntity> listarFormatosAByDocente(String nombreDocente);
    List<DocenteEntity> listarDocentesByRol(String nombreRol);
    List<DocenteEntity> listarTodo();
    Optional<DocenteEntity> docenteById(Long id);
    Long correoDocenteExiste(String correo);
    DocenteEntity obtenerReferencia(Long idDocente);
    boolean docenteExiste(Long idDocente);
}
