package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorioGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarEstadosGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EstadoEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.EstadoRepository;
@Repository
public class GestionarEstadoGatewayAdapter implements GestionarEstadosGatewayIntPort {

    @Autowired
    private EstadoRepository repository;

    @Override
    public EstadoEntity guardar(EstadoEntity estado) {
        return repository.save(estado);
    }

}
