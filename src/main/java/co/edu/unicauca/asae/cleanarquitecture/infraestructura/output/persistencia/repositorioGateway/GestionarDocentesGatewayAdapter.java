package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorioGateway;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarDocentesGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.DocenteRepository;

@Repository
public class GestionarDocentesGatewayAdapter implements GestionarDocentesGatewayIntPort {
    @Autowired
    private DocenteRepository repository;

    @Override
    public DocenteEntity guardar(DocenteEntity docente) {
        return repository.save(docente);
    }

    @Override
    public List<DocenteEntity> listarDocenteByGrupo(String nombreGrupo, String patron) {
        return repository.findByNombreGrupoAndApellidosDocenteStartingWithIgnoreCaseOrderByApellidosDocenteAsc(nombreGrupo, patron);
    }
    @Override
    public List<DocenteEntity> listarFormatosAByDocente(String nombreDocente){
        return repository.findByNombresDocenteContainsIgnoreCase(nombreDocente);
    }

    @Override
    public List<DocenteEntity> listarTodo() {
        return repository.findAll();
    }

    @Override
    public Optional<DocenteEntity> docenteById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Long correoDocenteExiste(String correo) {
        return repository.docenteExiste(correo);
    }

    @Override
    public DocenteEntity obtenerReferencia(Long idDocente) {
       return repository.getReferenceById(idDocente);
    }

    @Override
    public boolean docenteExiste(Long idDocente) {
        return repository.existsById(idDocente);
    }

}
