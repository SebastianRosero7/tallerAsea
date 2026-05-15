package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "docentes")
@Data
public class DocenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocente;

    @Column(name = "nombres_docente", length = 100)
    private String nombresDocente;

    @Column(name = "apellidos_docente", length = 100)
    private String apellidosDocente;

    @Column(name = "nombre_grupo", length = 50)
    private String nombreGrupo;

    @Column(length = 100, unique = true)
    private String correo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objDocente")
    private List<HistoricoEntity> historicos;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objDocente")
    private Set<FormatoAEntity> formatosA;


}
