package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.Estado;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.Evaluacion;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoA;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoPP;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoTI;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.Historico;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.Rol;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoPPDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoTIDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoATIDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoPPDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EstadoEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoPPEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoTIEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.HistoricoEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.RolEntity;

@Mapper(componentModel = "spring")
public interface FormatoAMapper {

    // ─────────────────────────────────────────────
    // Evaluacion
    // ─────────────────────────────────────────────

    @Mapping(target = "objFormatoA", ignore = true)  
    @Mapping(target = "observaciones", ignore = true) 
    EvaluacionEntity toEvaluacionEntity(Evaluacion dominio);

    @Mapping(target = "objFormatoA", ignore = true)
    @Mapping(target = "observaciones", ignore = true)
    Evaluacion toEvaluacion(EvaluacionEntity entity);

    // ─────────────────────────────────────────────
    // Estado
    // ─────────────────────────────────────────────

    @Mapping(target = "objFormatoA", ignore = true) 
    EstadoEntity toEstadoEntity(Estado dominio);

    @Mapping(target = "idEstado",           source = "idEstado")
    @Mapping(target = "estadoActual",       source = "estadoActual")
    @Mapping(target = "fechaRegistroEstado",source = "fechaRegistroEstado")
    Estado toEstado(EstadoEntity entity);

    // ─────────────────────────────────────────────
    // Rol
    // ─────────────────────────────────────────────

    @Mapping(target = "historicos", ignore = true) 
    RolEntity toRolEntity(Rol dominio);

    @Mapping(target = "historicos", ignore = true) 
    Rol toRol(RolEntity entity);

    // ─────────────────────────────────────────────
    // Historico
    // ─────────────────────────────────────────────

    @Mapping(target = "objRol",     source = "objRol")
    @Mapping(target = "objDocente", source = "objDocente")
    HistoricoEntity toHistoricoEntity(Historico dominio);

    @Mapping(target = "objRol",     source = "objRol")
    @Mapping(target = "objDocente", source = "objDocente")
    Historico toHistorico(HistoricoEntity entity);

    // ─────────────────────────────────────────────
    // DTO Peticion → Dominio
    // ─────────────────────────────────────────────

    @Mapping(target = "idFormatoA",   ignore = true)
    @Mapping(target = "objEstado",    ignore = true)
    @Mapping(target = "objDocente",   ignore = true)
    @Mapping(target = "evaluaciones", ignore = true)
    FormatoA dtoToFormatoA(FormatoADTOPeticion dto);

    @Mapping(target = "idFormatoA",   ignore = true)
    @Mapping(target = "objEstado",    ignore = true)
    @Mapping(target = "objDocente",   ignore = true)
    @Mapping(target = "evaluaciones", ignore = true)
    FormatoPP dtoToFormatoPP(FormatoPPDTOPeticion dto);

    @Mapping(target = "idFormatoA",   ignore = true)
    @Mapping(target = "objEstado",    ignore = true)
    @Mapping(target = "objDocente",   ignore = true)
    @Mapping(target = "evaluaciones", ignore = true)
    FormatoTI dtoToFormatoTI(FormatoTIDTOPeticion dto);

    // ─────────────────────────────────────────────
    // Dominio → Entity
    // ─────────────────────────────────────────────

    @Mapping(target = "evaluaciones", expression = "java(new java.util.HashSet<>(formato.getEvaluaciones() != null ? formato.getEvaluaciones().stream().map(this::toEvaluacionEntity).collect(java.util.stream.Collectors.toList()) : java.util.Collections.emptyList()))")
    FormatoAEntity toFormatoAEntity(FormatoA formato);

    @Mapping(target = "evaluaciones", ignore = true)
    FormatoPPEntity toFormatoPPEntity(FormatoPP dominio);

    @Mapping(target = "evaluaciones", ignore = true)
    FormatoTIEntity toFormatoTIEntity(FormatoTI dominio);

    // ─────────────────────────────────────────────
    // Entity → Dominio
    // ─────────────────────────────────────────────

    FormatoA entityToFormatoA(FormatoAEntity entity);

    FormatoPP entityToFormatoPP(FormatoPPEntity entity);

    FormatoTI entityToFormatoTI(FormatoTIEntity entity);

    // ─────────────────────────────────────────────
    // Dominio → DTO Respuesta
    // ─────────────────────────────────────────────

    @Mapping(target = "estado", source = "objEstado.estadoActual")
    FormatoADTORespuesta toFormatoADTORespuesta(FormatoA dominio);

    @Mapping(target = "estado", source = "objEstado.estadoActual")
    FormatoPPDTORespuesta toFormatoPPDTORespuesta(FormatoPP dominio);

    @Mapping(target = "estado", source = "objEstado.estadoActual")
    FormatoATIDTORespuesta toFormatoTIDTORespuesta(FormatoTI dominio);

    // ─────────────────────────────────────────────
    // Entity → DTO Respuesta
    // ─────────────────────────────────────────────

    @Mapping(target = "estado", source = "objEstado.estadoActual")
    FormatoADTORespuesta entityToFormatoADTORespuesta(FormatoAEntity entity);

    @Mapping(target = "estado", source = "objEstado.estadoActual")
    FormatoPPDTORespuesta entityToFormatoPPDTORespuesta(FormatoPPEntity entity);

    @Mapping(target = "estado", source = "objEstado.estadoActual")
    FormatoATIDTORespuesta entityToFormatoTIDTORespuesta(FormatoTIEntity entity);

    @AfterMapping
    default void asignarEstadoPorDefecto(@MappingTarget FormatoA formatoA) {
        if (formatoA.getObjEstado() == null) {
            Estado estadoInicial = new Estado(0, "En formulacion", new java.util.Date());
            formatoA.setObjEstado(estadoInicial);
        }
    }
}