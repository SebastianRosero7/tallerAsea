package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;


import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarFormatosACUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarDocentesGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosAGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosPPGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosTIGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoA;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoPP;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoTI;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoPPDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoTIDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.EvaluacioneQuery1DTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADetailsDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.ObservacionDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers.FormatoAMapper;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoPPEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoTIEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.ObservacionEntity;

@Service
public class GestionarFormatosACUAdapter implements GestionarFormatosACUIntPort {

    @Autowired
    private GestionarFormatosPPGatewayIntPort formatosPPGatewayIntPort;
    @Autowired
    private GestionarFormatosTIGatewayIntPort formatosTIGatewayIntPort;

    @Autowired
    private GestionarFormatosAGatewayIntPort formatosAGatewayIntPort;

    @Autowired
    private GestionarDocentesGatewayIntPort gestionarDocentesGatewayIntPort;

    @Autowired
    private FormatoAMapper formatoAMapper;

    @Override
    public FormatoADTORespuesta crear(FormatoADTOPeticion formato) {


    DocenteEntity docente = gestionarDocentesGatewayIntPort
        .docenteById(formato.getIdDocente())
        .orElseThrow(() -> 
            new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Error de dominio, el docente no existe"
            )
        );

        FormatoA formatoDominio = formatoAMapper.dtoToFormatoA(formato);

        if(formatosAGatewayIntPort.tituloFormatoExiste(formatoDominio.getTitulo())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error de dominio, el titulo ya esta registrado");
        }
        
        FormatoA formatoModelo = null;
        FormatoAEntity formatoAEntity = null;
        FormatoADTORespuesta formatoFespuesta = null; 

        if(formato instanceof FormatoPPDTOPeticion pp){
            formatoModelo = formatoAMapper.dtoToFormatoPP(pp);
            formatoAEntity = formatoAMapper.toFormatoPPEntity((FormatoPP) formatoModelo);
            formatoAEntity.setObjDocente(docente);
            formatoAEntity = formatosPPGatewayIntPort.guardar((FormatoPPEntity) formatoAEntity);
            formatoFespuesta = formatoAMapper.entityToFormatoPPDTORespuesta((FormatoPPEntity)formatoAEntity);
        }else if(formato instanceof FormatoTIDTOPeticion ti){
            formatoModelo = formatoAMapper.dtoToFormatoTI(ti);
            formatoAEntity = formatoAMapper.toFormatoTIEntity((FormatoTI) formatoModelo);
            formatoAEntity.setObjDocente(docente);
            formatoAEntity = formatosTIGatewayIntPort.guardar((FormatoTIEntity) formatoAEntity);
            formatoFespuesta = formatoAMapper.entityToFormatoTIDTORespuesta((FormatoTIEntity)formatoAEntity);
        }

        return formatoFespuesta;
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

    @Override
    @Transactional(readOnly = true)
    public Optional<FormatoADetailsDTORespuesta> listarFormatoADetalles(String tituloFormato) {
        FormatoAEntity formato = formatosAGatewayIntPort.formatoADetalles(tituloFormato).orElseThrow(() -> 
            new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Error de dominio, el formato no existe"
            ));

        FormatoADetailsDTORespuesta respuesta = new FormatoADetailsDTORespuesta();
        respuesta.setTitulo(tituloFormato);

        for (EvaluacionEntity evaluacionEntity : formato.getEvaluaciones()) {
            EvaluacioneQuery1DTORespuesta evaluacionRespuesta = new EvaluacioneQuery1DTORespuesta();
            evaluacionRespuesta.setConcepto(evaluacionEntity.getConcepto());
            evaluacionRespuesta.setFechaRegistroConcepto(evaluacionEntity.getFechaRegistroConcepto());

            for (ObservacionEntity observacionEntity : evaluacionEntity.getObservaciones()) {
                
                ObservacionDTORespuesta observacionRespuesta = new ObservacionDTORespuesta();
                observacionRespuesta.setObservcion(observacionEntity.getObservcion());
                observacionRespuesta.setFechaRegistro(observacionEntity.getFechaRegistro());
                observacionRespuesta.setTitulo(tituloFormato);
                
                for (DocenteEntity docenteEntity : observacionEntity.getDocentes()) {
                    observacionRespuesta.getNombreDocente().add(docenteEntity.getNombresDocente());
                    
                }
                evaluacionRespuesta.getObservaciones().add(observacionRespuesta);
            }
            respuesta.getEvaluaciones().add(evaluacionRespuesta);
        }
        return Optional.of(respuesta);
    }
}
