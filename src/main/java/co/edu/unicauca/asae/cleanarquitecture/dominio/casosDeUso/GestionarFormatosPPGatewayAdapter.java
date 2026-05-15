package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosPPGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoA;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta.FormatoADTORespuesta;
import org.springframework.stereotype.Service;

@Service
public class GestionarFormatosPPGatewayAdapter implements GestionarFormatosPPGatewayIntPort {

     @Override
    public FormatoADTORespuesta guardar(FormatoA formato) {
        // Aquí puedes implementar la lógica para guardar el formato en la base de datos o en cualquier otro almacenamiento.
        // Por ejemplo, podrías usar un repositorio para persistir el formato.
        // return formatoRepository.save(formato);
        return null; // Retorna el formato guardado o null si no se pudo guardar.
    }
}
