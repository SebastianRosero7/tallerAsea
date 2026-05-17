package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorioGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosTIGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoTIEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.FormatoTiRepository;

@Repository
public class GestionarFormatoTIGatewayAdapter implements GestionarFormatosTIGatewayIntPort {
    @Autowired
    private FormatoTiRepository repository;
    @Override
    public FormatoTIEntity guardar(FormatoTIEntity formato) {
        return repository.save(formato);
    }

}
