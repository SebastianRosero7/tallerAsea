package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.mappers;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoA;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoADTOPeticion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoPP;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoTI;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoPPDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoTIDTOPeticion;

@Mapper(componentModel = "spring")
public interface FormatoAMapper {

    @Mapping(target = "idFormatoA", ignore = true)
    FormatoPP toFormatoPP(FormatoPPDTOPeticion formato);
    
    @Mapping(target = "idFormatoA", ignore = true)
    FormatoTI toFormatoTI(FormatoTIDTOPeticion formato);

    @Mapping(target = "idFormatoA", ignore = true)
    FormatoA toFormatoA(FormatoADTOPeticion formato);



}
