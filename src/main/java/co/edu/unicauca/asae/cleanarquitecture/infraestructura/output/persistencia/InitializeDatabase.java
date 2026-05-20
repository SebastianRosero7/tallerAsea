package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.*;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class InitializeDatabase implements CommandLineRunner {

    @Autowired
    private DocenteRepository docenteRepository;
    
    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private HistoricoRepository historicoRepository;
    
    @Autowired
    private FormatoARepository formatoARepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private EvaluacionRepository evaluacionRepository;
    
    @Autowired
    private ObservacionRepository observacionRepository;

    @Override
    @Transactional  // ← Ahora funciona correctamente con CommandLineRunner
    public void run(String... args) throws Exception {
        //initializedb();
    }

    private void initializedb(){
        // 1. CREAR DOCENTES
        DocenteEntity docente1 = new DocenteEntity(null, "Daniel", "Paz", "GrupoA", "danielp@unicauca.edu.co", new ArrayList<>(), new HashSet<>());
        DocenteEntity docente2 = new DocenteEntity(null, "Andres", "Gomez", "GrupoB", "andresg@unicauca.edu.co", new ArrayList<>(), new HashSet<>());
        DocenteEntity docente3 = new DocenteEntity(null, "Maria", "Lopez", "GrupoA", "marial@unicauca.edu.co", new ArrayList<>(), new HashSet<>());
        DocenteEntity docente4 = new DocenteEntity(null, "Carlos", "Perez", "GrupoC", "carlosp@unicauca.edu.co", new ArrayList<>(), new HashSet<>());
        
        List<DocenteEntity> docentes = docenteRepository.saveAll(List.of(docente1, docente2, docente3, docente4));
        
        // 2. CREAR ROLES
        RolEntity rolDocente = new RolEntity();
        rolDocente.setRoleAsignado("DOCENTE");
        rolDocente.setHistoricos(new ArrayList<>());
        
        RolEntity rolRevisor = new RolEntity();
        rolRevisor.setRoleAsignado("MIEMBRO_DE_COMITE");
        rolRevisor.setHistoricos(new ArrayList<>());
        
        RolEntity rolDirector = new RolEntity();
        rolDirector.setRoleAsignado("DIRECTOR");
        rolDirector.setHistoricos(new ArrayList<>());
        
        List<RolEntity> roles = rolRepository.saveAll(List.of(rolDocente, rolRevisor, rolDirector));
        
        // 3. CREAR HISTÓRICOS (docentes con roles)
        HistoricoEntity hist1 = new HistoricoEntity();
        hist1.setActivo(1);
        hist1.setFechaInicio(new Date());
        hist1.setFechaFin(null);
        hist1.setObjDocente(docentes.get(0));
        hist1.setObjRol(roles.get(0)); // docente1 es DOCENTE
        
        HistoricoEntity hist2 = new HistoricoEntity();
        hist2.setActivo(1);
        hist2.setFechaInicio(new Date());
        hist2.setFechaFin(null);
        hist2.setObjDocente(docentes.get(1));
        hist2.setObjRol(roles.get(1)); // docente2 es REVISOR
        
        HistoricoEntity hist3 = new HistoricoEntity();
        hist3.setActivo(1);
        hist3.setFechaInicio(new Date());
        hist3.setFechaFin(null);
        hist3.setObjDocente(docentes.get(2));
        hist3.setObjRol(roles.get(2)); // docente3 es DIRECTOR
        
        List<HistoricoEntity> historicos = historicoRepository.saveAll(List.of(hist1, hist2, hist3));
        
        // 4. CREAR FORMATOS A
        FormatoAEntity formato1 = new FormatoAEntity();
        formato1.setTitulo("Evaluación Desempeño 2024");
        formato1.setObjetivoGeneral("Evaluar el desempeño docente en el periodo 2024");
        formato1.setObjetivosEspecificos("Medir competencias pedagógicas, investigativas y administrativas");
        formato1.setObjDocente(docentes.get(0));
        formato1.setEvaluaciones(new HashSet<>());
        
        FormatoAEntity formato2 = new FormatoAEntity();
        formato2.setTitulo("Evaluación Investigación 2024");
        formato2.setObjetivoGeneral("Evaluar la producción investigativa");
        formato2.setObjetivosEspecificos("Revisar publicaciones y proyectos de investigación");
        formato2.setObjDocente(docentes.get(1));
        formato2.setEvaluaciones(new HashSet<>());
        
        FormatoAEntity formato3 = new FormatoAEntity();
        formato3.setTitulo("Evaluación Docencia 2024");
        formato3.setObjetivoGeneral("Evaluar la actividad de docencia");
        formato3.setObjetivosEspecificos("Revisar metodología, contenidos y resultados de aprendizaje");
        formato3.setObjDocente(docentes.get(2));
        formato3.setEvaluaciones(new HashSet<>());
        
        List<FormatoAEntity> formatos = formatoARepository.saveAll(List.of(formato1, formato2, formato3));
        
        // 5. CREAR ESTADOS para los formatos
        EstadoEntity estado1 = new EstadoEntity();
        estado1.setEstadoActual("En formulacion");
        estado1.setFechaRegistroEstado(new Date());
        estado1.setObjFormatoA(formatos.get(0));
        
        EstadoEntity estado2 = new EstadoEntity();
        estado2.setEstadoActual("En revision");
        estado2.setFechaRegistroEstado(new Date());
        estado2.setObjFormatoA(formatos.get(1));
        
        EstadoEntity estado3 = new EstadoEntity();
        estado3.setEstadoActual("Completado");
        estado3.setFechaRegistroEstado(new Date());
        estado3.setObjFormatoA(formatos.get(2));
        
        List<EstadoEntity> estados = estadoRepository.saveAll(List.of(estado1, estado2, estado3));
        
        // 6. CREAR EVALUACIONES
        EvaluacionEntity eval1 = new EvaluacionEntity();
        eval1.setConcepto("Excelente desempeño en docencia");
        eval1.setFechaRegistroConcepto(new Date());
        eval1.setNombreCordinador("Dr. Juan Martínez");
        eval1.setObjFormatoA(formatos.get(0));
        eval1.setObservaciones(new ArrayList<>());
        
        EvaluacionEntity eval2 = new EvaluacionEntity();
        eval2.setConcepto("Muy buena productividad en investigación");
        eval2.setFechaRegistroConcepto(new Date());
        eval2.setNombreCordinador("Dra. Ana García");
        eval2.setObjFormatoA(formatos.get(1));
        eval2.setObservaciones(new ArrayList<>());
        
        EvaluacionEntity eval3 = new EvaluacionEntity();
        eval3.setConcepto("Cumplimiento satisfactorio");
        eval3.setFechaRegistroConcepto(new Date());
        eval3.setNombreCordinador("Prof. Carlos López");
        eval3.setObjFormatoA(formatos.get(2));
        eval3.setObservaciones(new ArrayList<>());
        
        List<EvaluacionEntity> evaluaciones = evaluacionRepository.saveAll(List.of(eval1, eval2, eval3));
        
        // 7. CREAR OBSERVACIONES
        ObservacionEntity obs1 = new ObservacionEntity();
        obs1.setObservcion("Se recomienda mejorar en uso de nuevas metodologías");
        obs1.setFechaRegistro(new Date());
        obs1.setObjEvaluacion(evaluaciones.get(0));
        obs1.setDocentes(new ArrayList<>(List.of(docentes.get(1))));
        
        ObservacionEntity obs2 = new ObservacionEntity();
        obs2.setObservcion("Excelente participación en congresos internacionales");
        obs2.setFechaRegistro(new Date());
        obs2.setObjEvaluacion(evaluaciones.get(1));
        obs2.setDocentes(new ArrayList<>(List.of(docentes.get(0), docentes.get(2))));
        
        ObservacionEntity obs3 = new ObservacionEntity();
        obs3.setObservcion("Debe aumentar producción académica");
        obs3.setFechaRegistro(new Date());
        obs3.setObjEvaluacion(evaluaciones.get(2));
        obs3.setDocentes(new ArrayList<>(List.of(docentes.get(3))));
        
        observacionRepository.saveAll(List.of(obs1, obs2, obs3));
    }

}
