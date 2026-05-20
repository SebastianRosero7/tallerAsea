package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarDocentesCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.DocenteDTORespuesta;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/docentes")
@CrossOrigin(origins = "*")
@Validated
public class DocenteRestController {

    @Autowired
    private GestionarDocentesCUIntPort docenteService;

    @GetMapping
    public ResponseEntity<?> listarDocentes(@RequestParam(required = false) String nombreGrupo, @RequestParam(required = false) String patron, @RequestParam(required = false) String nombreDocente) {
        Collection<DocenteDTORespuesta> docentes = docenteService.listarDocentes(nombreGrupo, patron, nombreDocente);
        return ResponseEntity.ok(docentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> encontrarDocente(@PathVariable Long id) {
        DocenteDTORespuesta docente = docenteService.findById(id);
        return ResponseEntity.ok(docente);
    }

    @PostMapping
    public ResponseEntity<?> crearDocente(@Valid @RequestBody DocenteDTOPeticion docente) {
        DocenteDTORespuesta nuevoDocente = docenteService.crear(docente);
        return ResponseEntity.ok(nuevoDocente);
    }

    @GetMapping("/existe_correo")
    public ResponseEntity<?> existeCorreoDOcente(@RequestParam String correo) {
        boolean respuesta = docenteService.existeCorreoDocente(correo);
        return ResponseEntity.ok(respuesta);
    }

}
