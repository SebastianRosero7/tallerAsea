package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepository extends JpaRepository<DocenteEntity,Integer> {
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
}
