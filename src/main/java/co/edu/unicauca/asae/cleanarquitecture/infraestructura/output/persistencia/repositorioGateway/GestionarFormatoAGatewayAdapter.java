package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorioGateway;


import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosAGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.FormatoARepository;

@Repository
public class GestionarFormatoAGatewayAdapter implements GestionarFormatosAGatewayIntPort {

    @Autowired
    private FormatoARepository repository;

    @Override
    public FormatoAEntity guardar(FormatoAEntity formato) {
        return repository.save(formato);
    }

    @Override
    public boolean tituloFormatoExiste(String titulo) {
        return repository.formatoAExiste(titulo) == 1;
    }

    @Override
    public FormatoAEntity obtenerReferencia(Long idFormato) {
        return repository.getReferenceById(idFormato);
    }

    @Override
    public boolean existeFormatoId(Long idFormato) {
        return repository.existsById(idFormato);
    }

    @Override
    public Optional<FormatoAEntity> formatoADetalles(String titulo) {
        return repository.formatoADetails(titulo);
    }

    @Override
    public Optional<FormatoAEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<FormatoAEntity> formatosByDocente(String nombreDocente) {
        return repository.findByObjDocenteNombresDocenteIgnoreCase(nombreDocente);
    }





}
