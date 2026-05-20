package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controladores;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarDocentesCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.DocenteDTORespuesta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/docentes")
@CrossOrigin(origins = "*")
@Validated
public class DocenteRestController {

    @Autowired
    private GestionarDocentesCUIntPort docenteService;

    @GetMapping
    public ResponseEntity<?> listarDocentes(@RequestParam(required = false) String nombreGrupo, @RequestParam(required = false) String patron, @RequestParam(required = false) String nombreDocente, @RequestParam(required = false) String nombreRol) {
        Collection<DocenteDTORespuesta> docentes = docenteService.listarDocentes(nombreGrupo, patron, nombreDocente, nombreRol);
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

}
