package co.edu.unicauca.asae.cleanarquitecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.HistoricoEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.ObservacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.DocenteRepository;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository repository;

    public void crear(String nombre, String apellidos, String correo){
        DocenteEntity docente = new DocenteEntity();
        docente.setNombresDocente(nombre);
        docente.setApellidosDocente(apellidos);
        docente.setCorreo(correo);
        docente.setNombreGrupo("GICO");
        
        repository.save(docente);
    }

    @Transactional(readOnly = true)
    public void listarMiembrosComite() {

        List<DocenteEntity> docentes = repository.findAllConRoles("Director");

        for (DocenteEntity docente : docentes) {
            System.out.println("=================================");
            System.out.println("Docente: " + docente.getNombresDocente() + " " + docente.getApellidosDocente());
            System.out.println("Correo: " + docente.getCorreo());

            for (HistoricoEntity historico : docente.getHistoricos()) {
                System.out.println("  -- Rol: " + historico.getObjRol().getRoleAsignado());
                System.out.println("  -- Fecha Inicio: " + historico.getFechaInicio());
                System.out.println("  -- Fecha Fin: " + historico.getFechaFin());
            }
        }
    }

    @Transactional(readOnly = true)
    public void consultarFormatosPorDocente(int idDoc) {
        DocenteEntity docente = repository.findByIdConFormatosAYEvaluaciones(idDoc)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));

        System.out.println("=================================");
        System.out.println("Docente: " + docente.getNombresDocente() + " " + docente.getApellidosDocente());
        System.out.println("Correo: " + docente.getCorreo());

        for (FormatoAEntity formato : docente.getFormatosA()) {
            System.out.println("  -- Formato: " + formato.getTitulo());
            System.out.println("  -- Objetivo General: " + formato.getObjetivoGeneral());

            for (EvaluacionEntity eval : formato.getEvaluaciones()) {
                System.out.println("    -- Evaluación: " + eval.getConcepto());
                System.out.println("    -- Coordinador: " + eval.getNombreCordinador());

                for (ObservacionEntity obs : eval.getObservaciones()) {
                    System.out.println("      -- Observación: " + obs.getObservcaion());
                    System.out.println("      -- Fecha: " + obs.getFechaRegistro());
                }
            }
        }
    }

    public void listarDocentes(String grupo, String apellido){
        List<DocenteEntity> lista = repository.findByNombreGrupoAndApellidosDocenteStartingWithIgnoreCaseOrderByApellidosDocenteAsc(grupo,apellido);
    
        for (DocenteEntity docenteEntity : lista) {
            System.out.println("---------------------------------");
            System.out.println("ID: "+docenteEntity.getIdDocente());
            System.out.println("NOMBRE: "+docenteEntity.getNombresDocente());
            System.out.println("APELLIDOS: "+docenteEntity.getApellidosDocente());
            System.out.println("GRUPO: "+ docenteEntity.getNombreGrupo());
        }
    }

    public void docenteExist(String correo){

        long exist = repository.docenteExiste(correo);

        System.out.println("-------------------------");

        if(exist == 1){
            System.out.println("EL DOCENTE EXISTE");
        }else{
            System.out.println("EL DOCENTE NO EXISTE");
        }

    }

}
