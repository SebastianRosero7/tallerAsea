package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarObservacionesCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.ObservacionDTORespuesta;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/api/observaciones")
@CrossOrigin(origins = "http://localhost:4200/")
@AllArgsConstructor
public class ObservacionRestController {

    private GestionarObservacionesCUIntPort service;

    @PostMapping()
    public ResponseEntity<ObservacionDTORespuesta> save(@RequestBody ObservacionDTOPeticion dtoObservacion) {
        ObservacionDTORespuesta respuesta = service.crear(dtoObservacion);
        return ResponseEntity.ok(respuesta);
    }

}
