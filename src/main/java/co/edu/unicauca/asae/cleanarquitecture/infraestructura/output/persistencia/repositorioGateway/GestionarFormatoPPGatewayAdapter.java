package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorioGateway;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.EvaluacionDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers.EvaluacionMapper;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers.FormatoAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarEvaluacionGategayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.EvaluacionRepository;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public class GestionarFormatoPPGatewayAdapter implements GestionarFormatosPPGatewayIntPort{
    @Autowired
    private EvaluacionRepository repository;
    @Autowired
    private EvaluacionMapper evaluacionMapper;

    @Override
    public FormatoPPEntity guardar(FormatoPPEntity formato) {
        return repository.save(formato);
    }

    @Override
    public List<EvaluacionDTORespuesta> buscarEvaluaciones(@Param("fechaInicio") Date fechaInicio, Date fechaFin, String nombreDocente){
        return repository.findByFechaRegistroConceptoBetweenAndNombreCordinadorIgnoreCaseContaining(fechaInicio, fechaFin, nombreDocente).stream().map(evaluacionDto -> evaluacionMapper.toEvaluacionDTORespuesta(evaluacionDto)).toList();
    }

}
