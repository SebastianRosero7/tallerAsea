package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa;

import java.util.List;
import java.util.Optional;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.springframework.stereotype.Repository;

import javax.print.Doc;

@Repository
public interface DocenteRepository extends JpaRepository<DocenteEntity,Long> {
    @Query("SELECT DISTINCT d FROM DocenteEntity d " +
        "JOIN FETCH d.historicos h " +
        "JOIN FETCH h.objRol r " +
        "WHERE r.roleAsignado = :rol")
    List<DocenteEntity> findAllConRoles(@Param("rol") String rol);

    @Query("SELECT DISTINCT d FROM DocenteEntity d " +
       "JOIN FETCH d.formatosA f " +
       "JOIN FETCH f.evaluaciones e " +
       "JOIN FETCH e.observaciones " +
       "WHERE d.idDocente = :id")
    Optional<DocenteEntity> findByIdConFormatosAYEvaluaciones(@Param("id") int id);


    List<DocenteEntity> findByNombreGrupoAndApellidosDocenteStartingWithIgnoreCaseOrderByApellidosDocenteAsc(
    String nombreGrupo, String apellidosDocente);

    @Query(value = """
        SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END
        FROM docentes d
        WHERE d.correo = :correoDocente
        """, nativeQuery = true)
    Long docenteExiste(@Param("correoDocente") String correo);

    @Query("SELECT d FROM DocenteEntity d " +
            "WHERE lower(d.nombreGrupo) = lower(:nombreGrupo) " +
            "AND lower(d.apellidosDocente) LIKE lower(concat(:patron, '%')) " +
            "ORDER BY lower(d.apellidosDocente) ASC")
    List<DocenteEntity> findByNombreGrupoAndApellidosStartingWithIgnoreCase(
            @Param("nombreGrupo") String nombreGrupo,
            @Param("patron") String patron
    );

    @Query("SELECT d FROM DocenteEntity d " +
            "WHERE lower(d.nombresDocente) = lower(:nombreDocente)")
    List<DocenteEntity> findByNombresDocente(String nombreDocente);

    List<DocenteEntity> findByNombresDocenteContainsIgnoreCase(String nombreDocente);

    @Query("SELECT d FROM DocenteEntity d " +
           "JOIN d.historicos h " +
           "JOIN h.objRol r " +
           "WHERE lower(r.roleAsignado) = lower(:nombreRol)")
    List<DocenteEntity> findByRol(String nombreRol);

}
