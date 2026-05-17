package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoPPEntity;

public interface GestionarFormatosPPGatewayIntPort {

    public FormatoPPEntity guardar(FormatoPPEntity formato);
}
