package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoA;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta.FormatoADTORespuesta;

public interface GestionarFormatosTIGatewayIntPort {
    public FormatoADTORespuesta guardar(FormatoA formato);
}
