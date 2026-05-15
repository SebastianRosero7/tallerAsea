package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.mappers;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.springframework.stereotype.Component;

@Component
public class DocenteMapper {

    /**
     * Convierte un DTO de petición a una entidad de persistencia
     */
    public DocenteEntity toEntity(DocenteDTOPeticion dto) {
        if (dto == null) {
            return null;
        }

        DocenteEntity entity = new DocenteEntity();
        entity.setNombresDocente(dto.getNombresDocente());
        entity.setApellidosDocente(dto.getApellidosDocente());
        entity.setNombreGrupo(dto.getNombreGrupo());
        entity.setCorreo(dto.getCorreo());
        // No mapear idDocente
        // No mapear historicos ni formatosA faltan los mappers correspondientes o se mapearan por id para evitar ciclos

        return entity;
    }

    /**
     * Convierte una entidad de persistencia a un DTO de respuesta
     */
    public DocenteDTORespuesta toDTORespuesta(DocenteEntity entity) {
        if (entity == null) {
            return null;
        }

        DocenteDTORespuesta dto = new DocenteDTORespuesta();
        dto.setIdDocente(entity.getIdDocente());
        dto.setNombresDocente(entity.getNombresDocente());
        dto.setApellidosDocente(entity.getApellidosDocente());
        dto.setNombreGrupo(entity.getNombreGrupo());
        dto.setCorreo(entity.getCorreo());
        // No mapear historicos ni formatosA (se cargan según sea necesario)

        return dto;
    }
}
