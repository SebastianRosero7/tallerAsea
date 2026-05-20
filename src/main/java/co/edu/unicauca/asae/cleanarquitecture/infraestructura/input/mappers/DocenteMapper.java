package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.HistoricoDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.RolDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.HistoricoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocenteMapper {

    @Autowired
    FormatoAMapper formatoAMapper;

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
        HistoricoMapper historicoMapper = new HistoricoMapper();
        DocenteDTORespuesta dto = new DocenteDTORespuesta();
        dto.setIdDocente(entity.getIdDocente());
        dto.setNombresDocente(entity.getNombresDocente());
        dto.setApellidosDocente(entity.getApellidosDocente());
        dto.setNombreGrupo(entity.getNombreGrupo());
        dto.setCorreo(entity.getCorreo());
        List<HistoricoDTORespuesta> historicos = entity.getHistoricos() != null ? entity.getHistoricos().stream().map(historicoMapper::toDTO).toList() : null;
        dto.setHistoricos(historicos);

        List<FormatoADTORespuesta> formatosA = entity.getFormatosA() != null ? entity.getFormatosA().stream()
                .map(formato -> {
                    return formatoAMapper.entityToFormatoADTORespuesta(formato);
                })
                .toList() : null;
        dto.setFormatosA(formatosA);
        // No mapear historicos ni formatosA (se cargan según sea necesario)

        return dto;
    }
}
