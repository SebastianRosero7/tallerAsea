package co.edu.unicauca.asae.cleanarquitecture.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EstadoEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.ObservacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.EstadoRepository;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.FormatoARepository;
import jakarta.transaction.Transactional;

@Service
public class FormatoAService {

    @Autowired
    private FormatoARepository formatoARepository;

    @Autowired
    private EstadoRepository estadoRepository;


    public void listarFormatos(String nombreDoc){
        List<FormatoAEntity> list = formatoARepository.findByObjDocenteNombresDocenteIgnoreCase(nombreDoc);

        for (FormatoAEntity formatoAEntity : list) {
            System.out.println("----------------------------------------");
            System.out.println("Titulo: "+formatoAEntity.getTitulo());
            System.out.println("Objetivo: "+formatoAEntity.getObjetivoGeneral());
            System.out.println("Docente nombre: "+formatoAEntity.getObjDocente().getNombresDocente());
            System.out.println("Docente Apellido: "+formatoAEntity.getObjDocente().getApellidosDocente());
        }
    }

    public void formatoADeatils(String titulo){
        FormatoAEntity formato = formatoARepository.formatoADetails(titulo).orElse(null);

        System.out.println("TITULO: "+formato.getTitulo());

        for (EvaluacionEntity evaluacionEntity : formato.getEvaluaciones()) {
            System.out.println("-------------------------------------");
            System.out.println("CONCEPTO DE EVALUACION: "+evaluacionEntity.getConcepto());

            for (ObservacionEntity observacionEntity : evaluacionEntity.getObservaciones()) {
                
                System.out.println("OBSERVACIONES: "+observacionEntity.getObservcaion());
                
                for (DocenteEntity docenteEntity : observacionEntity.getDocentes()) {
                    System.out.println("HECHA POR: "+docenteEntity.getNombresDocente());
                    
                }
            }
        }
    }

    public void formatoAexist(String titulo){
        long exist = formatoARepository.formatoAExiste(titulo);
        System.out.println("----------------------------------------");
        if(exist == 1){
            System.out.println("El formato si existe");
        }else{
            System.out.println("El formato NO existe");
        }
    }

    @Transactional
    public void agregarEstado(int idFormato, String nuevoEstado) {
        FormatoAEntity formato = formatoARepository.findById(idFormato)
                .orElseThrow(() -> new RuntimeException("Formato no encontrado"));

        EstadoEntity estado = new EstadoEntity();
        estado.setEstadoActual(nuevoEstado);
        estado.setFechaRegistroEstado(new Date());
        estado.setObjFormatoA(formato);

        estadoRepository.save(estado);
        System.out.println("TITULO: "+formato.getTitulo());
        System.out.println("ESTADO: "+estado.getEstadoActual());
    }

}
