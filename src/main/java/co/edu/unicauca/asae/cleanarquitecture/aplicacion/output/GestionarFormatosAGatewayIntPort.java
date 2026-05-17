package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoAEntity;

public interface GestionarFormatosAGatewayIntPort {
    public FormatoAEntity guardar(FormatoAEntity formato);
    public boolean tituloFormatoExiste(String nombre);
}
