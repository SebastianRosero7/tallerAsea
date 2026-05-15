package co.edu.unicauca.asae.cleanarquitecture.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.ObservacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.DocenteRepository;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.EvaluacionRepository;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.FormatoARepository;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.FormatoPPRepository;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.ObservacionRepository;

@Service
public class ObservacionService {

    @Autowired
    private ObservacionRepository observacionRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private FormatoARepository formatoARepository;

    @Transactional
    public void crear(int  idFormato, Long idDoc, String obs) {

        List<Long> idsDocentes = List.of(idDoc);

        EvaluacionEntity evaluacion = new EvaluacionEntity();
        evaluacion.setConcepto("Formulado con observaciones");
        evaluacion.setFechaRegistroConcepto(new Date());
        evaluacion.setNombreCordinador("Julio");
        evaluacion.setObjFormatoA(formatoARepository.getReferenceById(idFormato));
        EvaluacionEntity evaluacionGuardada = evaluacionRepository.save(evaluacion);

        List<DocenteEntity> docentes = new ArrayList<>();
        for (Long idDocente : idsDocentes) {
            docentes.add(docenteRepository.getReferenceById(idDocente));
        }

        ObservacionEntity observacion = new ObservacionEntity();
        observacion.setObservcaion(obs);
        observacion.setFechaRegistro(new Date());
        observacion.setObjEvaluacion(evaluacionGuardada);
        observacion.setDocentes(docentes);

        observacionRepository.save(observacion);
    }

    @Transactional(readOnly = true)
    public void listar(int idFormato) {

        FormatoAEntity formato = formatoARepository.findById(idFormato)
                .orElseThrow(() -> new RuntimeException("Formato no encontrado"));

        System.out.println("=================================");
        System.out.println("Título: " + formato.getTitulo());
        System.out.println("Objetivo General: " + formato.getObjetivoGeneral());
        System.out.println("Estado: " + formato.getObjEstado().getEstadoActual());

        for (EvaluacionEntity eval : formato.getEvaluaciones()) {
            System.out.println("  -- Evaluación: " + eval.getConcepto());
            System.out.println("  -- Coordinador: " + eval.getNombreCordinador());

            for (ObservacionEntity obs : eval.getObservaciones()) {
                System.out.println("    -- Observación: " + obs.getObservcaion());

                for (DocenteEntity docente : obs.getDocentes()) {
                    System.out.println("      -- Docente: " + docente.getNombresDocente());
                }
            }
        }
    }

}
