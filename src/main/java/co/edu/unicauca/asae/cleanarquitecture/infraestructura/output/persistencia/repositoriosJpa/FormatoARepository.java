package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoAEntity;


public interface FormatoARepository extends JpaRepository<FormatoAEntity,Long>{
    
    List<FormatoAEntity> findByObjDocenteNombresDocenteIgnoreCase(String nombreDocente);

    @Query("""
    SELECT DISTINCT f 
    FROM FormatoAEntity f 
    JOIN FETCH f.objDocente d
    LEFT JOIN FETCH f.evaluaciones e
    LEFT JOIN FETCH e.observaciones o
    WHERE f.titulo = :tituloFormatoA
    """)
    Optional<FormatoAEntity> formatoADetails(@Param("tituloFormatoA") String titulo);

    @Query(value = """
        SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END
        FROM formatos_a f
        WHERE f.titulo = :tituloFormatoA
        """, nativeQuery = true)
    Long formatoAExiste(@Param("tituloFormatoA") String titulo);
}
