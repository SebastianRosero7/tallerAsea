package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorioGateway;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.EvaluacionDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers.EvaluacionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarEvaluacionGategayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.EvaluacionRepository;

import java.util.Date;
import java.util.List;

@Repository
public class GestionarEvaluacionGatewayIntPort implements GestionarEvaluacionGategayIntPort{
    @Autowired
    private EvaluacionRepository repository;
    @Autowired
    private EvaluacionMapper evaluacionMapper;


    @Override
    public EvaluacionEntity guardar(EvaluacionEntity evaluacionEntity) {
        return repository.save(evaluacionEntity);
    }

    @Override
    public List<EvaluacionDTORespuesta> buscarEvaluaciones(Date fechaInicio, Date fechaFin, String nombreDocente) {
        List<EvaluacionEntity> evaluaciones = repository.findByFechaRegistroConceptoBetweenAndNombreCordinadorIgnoreCaseContaining(fechaInicio, fechaFin, nombreDocente);
        return evaluaciones.stream().map(evaluacionEntity -> evaluacionMapper.toEvaluacionDTORespuesta(evaluacionEntity)).toList();
    }

}
