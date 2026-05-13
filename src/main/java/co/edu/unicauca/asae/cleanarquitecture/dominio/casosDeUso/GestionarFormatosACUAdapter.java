package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarFormatosACUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosPPGetwayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarFormatosTIGetwayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoA;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.FormatoPP;

@Service
public class GestionarFormatosACUAdapter implements GestionarFormatosACUIntPort {

    @Autowired
    private GestionarFormatosPPGetwayIntPort formatosPPGetwayIntPort;
    @Autowired
    private GestionarFormatosTIGetwayIntPort formatosTIGetwayIntPort;

    @Override
    public FormatoA crear(FormatoA formato) {
        if(formato instanceof FormatoPP){
            return formatosPPGetwayIntPort.guardar(formato);
        }else{
            return formatosTIGetwayIntPort.guardar(formato);
        }
    }



}
