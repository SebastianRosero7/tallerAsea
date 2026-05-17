package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;


import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarFormatosACUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosAGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosPPGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosTIGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoA;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoPP;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoTI;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoPPDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoTIDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta.FormatoADTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.mappers.FormatoAMapper;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoPPEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoTIEntity;

@Service
public class GestionarFormatosACUAdapter implements GestionarFormatosACUIntPort {

    @Autowired
    private GestionarFormatosPPGatewayIntPort formatosPPGatewayIntPort;
    @Autowired
    private GestionarFormatosTIGatewayIntPort formatosTIGatewayIntPort;

    @Autowired
    private GestionarFormatosAGatewayIntPort formatosAGatewayIntPort;

    @Autowired
    private FormatoAMapper formatoAMapper;

    @Override
    public FormatoADTORespuesta crear(FormatoADTOPeticion formato) {
        FormatoA formatoDominio = formatoAMapper.dtoToFormatoA(formato);

        if(formatosAGatewayIntPort.tituloFormatoExiste(formatoDominio.getTitulo())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error de dominio, el titulo ya esta registrado");
        }

        FormatoA formatoModelo=null;
        FormatoAEntity formatoAEntity=null;

        if(formato instanceof FormatoPPDTOPeticion pp){
            formatoModelo = formatoAMapper.dtoToFormatoPP(pp);
            formatoAEntity = formatoAMapper.toFormatoPPEntity((FormatoPP) formatoModelo);
            formatoAEntity = formatosPPGatewayIntPort.guardar((FormatoPPEntity) formatoAEntity);
        }else if(formato instanceof FormatoTIDTOPeticion ti){
            formatoModelo = formatoAMapper.dtoToFormatoTI(ti);
            formatoAEntity = formatoAMapper.toFormatoTiEntity((FormatoTI) formatoModelo);
            formatoAEntity = formatosTIGatewayIntPort.guardar((FormatoTIEntity) formatoAEntity);

        }

        return formatoAMapper.toFormatoADTORespuesta(formatoModelo);
    }

    @Override
    public Optional<FormatoADTORespuesta> findById(Long id) {

        return Optional.empty();
    }

    @Override
    public Optional<Collection<FormatoADTORespuesta>> findByRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return Optional.empty();
    }

    @Override
    public Optional<Collection<FormatoADTORespuesta>> findAll() {
        return Optional.empty();
    }


}
