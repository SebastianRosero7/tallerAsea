package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarObservacionesCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarDocentesGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosAGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarObservacionesGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.ObservacionDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers.ObservacionMapper;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.ObservacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorioGateway.GestionarEvaluacionGatewayIntPort;

@Service
public class GestionarObservacionCUAdapter implements GestionarObservacionesCUIntPort {

    @Autowired
    private GestionarObservacionesGatewayIntPort gestionarObservacionesGatewayIntPort;
    @Autowired
    private GestionarDocentesGatewayIntPort gestionarDocentesGatewayIntPort;

    @Autowired
    private GestionarFormatosAGatewayIntPort gestionarFormatosAGatewayIntPort;

    @Autowired
    private GestionarEvaluacionGatewayIntPort gestionarEvaluacionGatewayIntPort;

    @Autowired
    private ObservacionMapper mapper;

    @Override
    public ObservacionDTORespuesta crear(ObservacionDTOPeticion dtoObservacion) {

        List<DocenteEntity> docentes = new ArrayList<>();
        for (Long idDocente : dtoObservacion.getIdDocentes()) {
            if(!gestionarDocentesGatewayIntPort.docenteExiste(idDocente)){
                throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Error de dominio, el docente no existe"
                );
            }
            docentes.add(gestionarDocentesGatewayIntPort.obtenerReferencia(idDocente));
        }

        EvaluacionEntity evaluacionEntity = new EvaluacionEntity();

        evaluacionEntity.setConcepto("Corregir");
        evaluacionEntity.setFechaRegistroConcepto(new Date());
        evaluacionEntity.setNombreCordinador(dtoObservacion.getNombreCordinador());

        if(!gestionarFormatosAGatewayIntPort.existeFormatoId(dtoObservacion.getIdFormato())){
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Error de dominio, el formato no existe"
                );
        }
        evaluacionEntity.setObjFormatoA(gestionarFormatosAGatewayIntPort.obtenerReferencia(dtoObservacion.getIdFormato()));
        EvaluacionEntity evaluacionGuardada = gestionarEvaluacionGatewayIntPort.guardar(evaluacionEntity);

        ObservacionEntity observacion = new ObservacionEntity();
        observacion.setObservcion(dtoObservacion.getObservacion());
        observacion.setFechaRegistro(new Date());
        observacion.setObjEvaluacion(evaluacionGuardada);
        observacion.setDocentes(docentes);

        return mapper.toObservacionDTORespuesta(gestionarObservacionesGatewayIntPort.guardar(observacion));
    }

}
