package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoTIEntity;

public interface GestionarFormatosTIGatewayIntPort {
    public FormatoTIEntity guardar(FormatoTIEntity formato);
}
