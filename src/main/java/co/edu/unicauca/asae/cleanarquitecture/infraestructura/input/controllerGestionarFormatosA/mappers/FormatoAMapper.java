package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoA;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoPP;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoTI;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoPPDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoTIDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta.FormatoADTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta.FormatoATIDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta.FormatoPPDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoPPEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoTIEntity;

@Mapper(componentModel = "spring")
public interface FormatoAMapper {

    @Mapping(target = "idFormatoA", ignore = true)
    FormatoA dtoToFormatoA(FormatoADTOPeticion formato);       // ← DTOPeticion → Modelo

    FormatoA entityToFormatoA(FormatoAEntity formato);          // ← Entity → Modelo

    @Mapping(target = "idFormatoA", ignore = true)
    FormatoPP dtoToFormatoPP(FormatoPPDTOPeticion formato);    // ← DTOPeticion → Modelo

    FormatoPP entityToFormatoPP(FormatoPPEntity formato);       // ← Entity → Modelo

    @Mapping(target = "idFormatoA", ignore = true)
    FormatoTI dtoToFormatoTI(FormatoTIDTOPeticion formato);    // ← DTOPeticion → Modelo

    FormatoTI entityToFormatoTI(FormatoTIEntity formatoTIEntity); // ← Entity → Modelo

    @Mapping(target = "evaluaciones", ignore = true)
    FormatoAEntity toFormatoAEntity(FormatoA formato);

    @Mapping(target = "idFormatoA", ignore = true)
    FormatoPPEntity toFormatoPPEntity(FormatoPP formato);

    @Mapping(target = "idFormatoA", ignore = true)
    FormatoTIEntity toFormatoTiEntity(FormatoTI formato);

    FormatoADTORespuesta toFormatoADTORespuesta(FormatoA formato);
    FormatoPPDTORespuesta toFormatoPPDTORespuesta(FormatoPP formato);
    FormatoATIDTORespuesta toFormatoTIDTORespuesta(FormatoTI formato);
}
