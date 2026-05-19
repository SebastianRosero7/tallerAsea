package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.ObservacionDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.ObservacionEntity;

@Mapper(componentModel = "spring")
public interface ObservacionMapper {

    @Mapping(source = "objEvaluacion.objFormatoA.titulo", target = "titulo")
    @Mapping(target = "nombreDocente", expression = "java(entity.getDocentes().stream().map(d -> d.getNombresDocente()).collect(java.util.stream.Collectors.toList()))")
    ObservacionDTORespuesta toObservacionDTORespuesta(ObservacionEntity entity);
}
