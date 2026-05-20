package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controladores;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarFormatosACUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelo.EstadoEnum;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADetailsDTORespuesta;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/formatos")
@CrossOrigin(origins = "http://localhost:4200/")
@Validated
public class FormatoARestController {
    @Autowired
    private GestionarFormatosACUIntPort service;

    @PostMapping()
    public ResponseEntity<FormatoADTORespuesta> save(@Valid @RequestBody FormatoADTOPeticion objFormato) {
        FormatoADTORespuesta respuesta = service.crear(objFormato);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormatoADTORespuesta> findById(@PathVariable Long id) {
        Optional<FormatoADTORespuesta> respuesta = service.findById(id);
        return respuesta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/rango-fechas")
    public ResponseEntity<Collection<FormatoADTORespuesta>> findByRangoFechas(
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {
        Optional<Collection<FormatoADTORespuesta>> respuesta = service.findByRangoFechas(fechaInicio, fechaFin);
        return respuesta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Collection<FormatoADTORespuesta>> findAll() {
        Optional<Collection<FormatoADTORespuesta>> respuesta = service.findAll();
        return respuesta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/formatosADetails")
    public ResponseEntity<Optional<FormatoADetailsDTORespuesta>> formatoADetails(@RequestParam String tituloFormato){
        Optional<FormatoADetailsDTORespuesta> respuesta = service.listarFormatoADetalles(tituloFormato);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/existe_titulo")
    public ResponseEntity<Boolean> existeTituloFormato(@RequestParam String tituloFormato){
        boolean respuesta = service.existeTituloFormato(tituloFormato);
        return ResponseEntity.ok(respuesta);
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<FormatoADTORespuesta> agregarEstado(@PathVariable Long id, @RequestParam EstadoEnum estado){
        return ResponseEntity.ok(service.agregarEstado(id, estado));
    }

}

