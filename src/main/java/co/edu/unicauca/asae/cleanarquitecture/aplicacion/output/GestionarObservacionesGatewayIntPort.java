package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.ObservacionEntity;

public interface GestionarObservacionesGatewayIntPort {

    public ObservacionEntity guardar(ObservacionEntity observacionEntity);
}
