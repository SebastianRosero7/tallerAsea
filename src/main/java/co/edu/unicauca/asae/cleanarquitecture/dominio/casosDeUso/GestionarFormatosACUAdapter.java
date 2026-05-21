package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarFormatosACUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarDocentesGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarEstadosGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosAGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosPPGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosTIGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.EstadoEnum;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoA;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoPP;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoTI;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.ActualizarFormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoPPDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoTIDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.EvaluacioneQuery1DTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADetailsDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.ObservacionDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers.FormatoAMapper;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EstadoEntity;
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
    private GestionarEstadosGatewayIntPort gestionarEstadosGatewayIntPort;

    @Autowired
    private FormatoAMapper formatoAMapper;

    @Override
    public FormatoADTORespuesta crear(FormatoADTOPeticion formato) {

        DocenteEntity docente = gestionarDocentesGatewayIntPort
                .docenteById(formato.getIdDocente())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.CONFLICT,
                        "Error de dominio, el docente no existe"));

        FormatoA formatoDominio = formatoAMapper.dtoToFormatoA(formato);

        if (formatosAGatewayIntPort.tituloFormatoExiste(formatoDominio.getTitulo())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error de dominio, el titulo ya esta registrado");
        }

        FormatoA formatoModelo = null;
        FormatoAEntity formatoAEntity = null;
        FormatoADTORespuesta formatoFespuesta = null;
        EstadoEntity estado = new EstadoEntity();
        estado.setEstadoActual(EstadoEnum.FORMULADO.name());
        estado.setFechaRegistroEstado(new Date());

        if (formato instanceof FormatoPPDTOPeticion pp) {
            formatoModelo = formatoAMapper.dtoToFormatoPP(pp);
            formatoAEntity = formatoAMapper.toFormatoPPEntity((FormatoPP) formatoModelo);
            formatoAEntity.setObjDocente(docente);
            estado.setObjFormatoA(formatoAEntity);
            formatoAEntity.setObjEstado(estado);
            formatoAEntity = formatosPPGatewayIntPort.guardar((FormatoPPEntity) formatoAEntity);
            estado.setObjFormatoA(formatoAEntity);
            formatoFespuesta = formatoAMapper.entityToFormatoPPDTORespuesta((FormatoPPEntity) formatoAEntity);
        } else if (formato instanceof FormatoTIDTOPeticion ti) {
            formatoModelo = formatoAMapper.dtoToFormatoTI(ti);
            formatoAEntity = formatoAMapper.toFormatoTIEntity((FormatoTI) formatoModelo);
            formatoAEntity.setObjDocente(docente);
            estado.setObjFormatoA(formatoAEntity);
            formatoAEntity.setObjEstado(estado);
            formatoAEntity = formatosTIGatewayIntPort.guardar((FormatoTIEntity) formatoAEntity);
            formatoFespuesta = formatoAMapper.entityToFormatoTIDTORespuesta((FormatoTIEntity) formatoAEntity);
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
        FormatoAEntity formato = formatosAGatewayIntPort.formatoADetalles(tituloFormato)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Error de dominio, el formato no existe"));

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

    @Override
    public boolean existeTituloFormato(String titulo) {
        return formatosAGatewayIntPort.tituloFormatoExiste(titulo);
    }

    @Override
    public FormatoADTORespuesta agregarEstado(Long id, EstadoEnum estado) {
        FormatoAEntity formato = formatosAGatewayIntPort.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Error de dominio, el formato no existe"));
        EstadoEntity estadoEntity = formato.getObjEstado();

        estadoEntity.setEstadoActual(estado.name());
        estadoEntity.setFechaRegistroEstado(new Date());

        formato.setObjEstado(estadoEntity);
        formatosAGatewayIntPort.guardar(formato);

        return formatoAMapper.entityToFormatoADTORespuesta(formato);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormatoADetailsDTORespuesta> formatosByDocente(String nombreDocente) {
        List<FormatoAEntity> formatos = formatosAGatewayIntPort.formatosByDocente(nombreDocente);
        List<FormatoADetailsDTORespuesta> respuestas = new ArrayList<>();

        for(FormatoAEntity formatoEntity : formatos){
            FormatoADetailsDTORespuesta respuesta = new FormatoADetailsDTORespuesta();
            respuesta.setTitulo(formatoEntity.getTitulo());

            for (EvaluacionEntity evaluacionEntity : formatoEntity.getEvaluaciones()) {
                EvaluacioneQuery1DTORespuesta evaluacionRespuesta = new EvaluacioneQuery1DTORespuesta();
                evaluacionRespuesta.setConcepto(evaluacionEntity.getConcepto());
                evaluacionRespuesta.setFechaRegistroConcepto(evaluacionEntity.getFechaRegistroConcepto());

                for (ObservacionEntity observacionEntity : evaluacionEntity.getObservaciones()) {
                    
                    ObservacionDTORespuesta observacionRespuesta = new ObservacionDTORespuesta();
                    observacionRespuesta.setObservcion(observacionEntity.getObservcion());
                    observacionRespuesta.setFechaRegistro(observacionEntity.getFechaRegistro());
                    observacionRespuesta.setTitulo(formatoEntity.getTitulo());
                    
                    for (DocenteEntity docenteEntity : observacionEntity.getDocentes()) {
                        observacionRespuesta.getNombreDocente().add(docenteEntity.getNombresDocente());
                        
                    }
                    evaluacionRespuesta.getObservaciones().add(observacionRespuesta);
                }
                respuesta.getEvaluaciones().add(evaluacionRespuesta);
            }
            respuestas.add(respuesta);
        }
        return respuestas;
    }

    @Override
    public FormatoADTORespuesta actualizar(Long idFormato, ActualizarFormatoADTOPeticion formato) {
        FormatoAEntity formatoEntity = formatosAGatewayIntPort.findById(idFormato).orElseThrow(
            ()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Error de dominio, el formato no existe")
        );

        if(formato.getObjetivoGeneral()!=null){
            formatoEntity.setObjetivoGeneral(formato.getObjetivoGeneral());
        }

        if(formato.getObjetivosEspecificos()!=null){
            formatoEntity.setObjetivosEspecificos(formato.getObjetivosEspecificos());
        }

        if(formato.getTitulo()!=null){
            if(formatosAGatewayIntPort.tituloFormatoExiste(formato.getTitulo())){
                throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Error de dominio, el titulo ya existe");
            }

            formatoEntity.setTitulo(formato.getTitulo());
        }

        return formatoAMapper.entityToFormatoADTORespuesta(formatosAGatewayIntPort.guardar(formatoEntity));

    }
}
