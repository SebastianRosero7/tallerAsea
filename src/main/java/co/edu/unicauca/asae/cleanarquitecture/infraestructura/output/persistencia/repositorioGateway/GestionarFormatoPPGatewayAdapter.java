package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorioGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosPPGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoPPEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.FormatoPPRepository;

@Repository
public class GestionarFormatoPPGatewayAdapter implements GestionarFormatosPPGatewayIntPort{
    @Autowired
    private FormatoPPRepository repository;

    @Override
    public FormatoPPEntity guardar(FormatoPPEntity formato) {
        return repository.save(formato);
    }
}
