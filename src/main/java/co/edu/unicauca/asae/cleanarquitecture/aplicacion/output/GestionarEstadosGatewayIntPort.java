package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EstadoEntity;

public interface GestionarEstadosGatewayIntPort {

    public EstadoEntity guardar(EstadoEntity estado);

}
