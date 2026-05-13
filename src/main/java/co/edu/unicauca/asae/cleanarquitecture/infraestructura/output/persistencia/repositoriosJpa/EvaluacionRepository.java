package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;


public interface EvaluacionRepository extends JpaRepository<EvaluacionEntity,Integer> {

    List<EvaluacionEntity>
    findByFechaRegistroConceptoBetweenAndNombreCordinadorIgnoreCaseContaining(
    Date fechaInicio,
    Date fechaFin,
    String nombre);
}
