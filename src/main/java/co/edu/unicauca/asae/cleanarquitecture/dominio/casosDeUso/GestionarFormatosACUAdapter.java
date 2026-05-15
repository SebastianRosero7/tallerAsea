package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;


import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta.FormatoADTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.mappers.FormatoAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarFormatosACUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosPPGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosTIGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoA;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoPP;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class GestionarFormatosACUAdapter implements GestionarFormatosACUIntPort {

    @Autowired
    private GestionarFormatosPPGatewayIntPort formatosPPGatewayIntPort;
    @Autowired
    private GestionarFormatosTIGatewayIntPort formatosTIGatewayIntPort;
    @Autowired
    private FormatoAMapper formatoAMapper;

    @Override
    public FormatoADTORespuesta crear(FormatoADTOPeticion formato) {
        FormatoA formatoObj = formatoAMapper.toFormatoA(formato);
        if(formatoObj instanceof FormatoPP){
            return formatosPPGatewayIntPort.guardar(formatoObj);
        }else{
            return formatosTIGatewayIntPort.guardar(formatoObj);
        }
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
