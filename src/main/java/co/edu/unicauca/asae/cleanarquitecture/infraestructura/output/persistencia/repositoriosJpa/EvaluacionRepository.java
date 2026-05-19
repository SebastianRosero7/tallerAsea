package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EvaluacionRepository extends JpaRepository<EvaluacionEntity,Integer> {

    List<EvaluacionEntity>
    findByFechaRegistroConceptoBetweenAndNombreCordinadorIgnoreCaseContaining(
    Date fechaInicio,
    Date fechaFin,
    String nombre);


//    @Query("SELECT e FROM EvaluacionEntity e " +
//            "WHERE lower(e.objFormatoA.objDocente.nombresDocente) LIKE lower(concat('%', :nombreDocente, '%')) " +
//            "AND e.fechaRegistroConcepto BETWEEN :fechaInicio AND :fechaFin")
//    List<EvaluacionEntity> findByFechaRegistroBetweenAndDocenteNombresContainingIgnoreCase(
//            @Param("fechaInicio") LocalDate fechaInicio,
//            @Param("fechaFin") LocalDate fechaFin,
//            @Param("nombreDocente") String nombreDocente
//    );
}
