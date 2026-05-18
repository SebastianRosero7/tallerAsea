package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorioGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarEvaluacionGategayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.EvaluacionRepository;
@Repository
public class GestionarEvaluacionGatewayIntPort implements GestionarEvaluacionGategayIntPort{
    @Autowired
    private EvaluacionRepository repository;
    @Override
    public EvaluacionEntity guardar(EvaluacionEntity evaluacionEntity) {
        return repository.save(evaluacionEntity);
    }

}
