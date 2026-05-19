package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorioGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarObservacionesGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.ObservacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.ObservacionRepository;

@Repository
public class GestionarObservacionesGatewayAdapter implements GestionarObservacionesGatewayIntPort{

    @Autowired
    private ObservacionRepository repository;
    @Override
    public ObservacionEntity guardar(ObservacionEntity observacionEntity) {
        return repository.save(observacionEntity);
    }

}
