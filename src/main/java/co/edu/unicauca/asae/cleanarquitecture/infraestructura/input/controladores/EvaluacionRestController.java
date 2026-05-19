package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controladores;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarEvaluacionGategayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.EvaluacionDTORespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
@CrossOrigin(origins = "*")
public class EvaluacionRestController {

    @Autowired
    private GestionarEvaluacionGategayIntPort evaluacionService;

    @GetMapping
    public List<EvaluacionDTORespuesta> buscarEvaluaciones(@RequestParam String fechaInicio,
                                                           @RequestParam String fechaFin,
                                                           @RequestParam String nombreDocente){
        Date fechaInicioLD = Date.from(LocalDate.parse(fechaInicio).atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant());
        Date fechaFinLD = Date.from(LocalDate.parse(fechaFin).atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant());
        List<EvaluacionDTORespuesta> evaluaciones = evaluacionService.buscarEvaluaciones(fechaInicioLD, fechaFinLD, nombreDocente);
        return evaluaciones;
    }
}
