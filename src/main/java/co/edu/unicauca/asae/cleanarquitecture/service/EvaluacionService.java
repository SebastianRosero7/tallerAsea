package co.edu.unicauca.asae.cleanarquitecture.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.EvaluacionRepository;

@Service
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository evaluacionRepository;


    public void evaluacionesFecha(String fechaInicio, String fechaFin, String nombreDoc){
        List<EvaluacionEntity> lista = evaluacionRepository.findByFechaRegistroConceptoBetweenAndNombreCordinadorIgnoreCaseContaining
        (new Date(fechaInicio), new Date(fechaFin), nombreDoc);

        for (EvaluacionEntity evaluacionEntity : lista) {
            System.out.println("-----------------------------------------");
            System.out.println("DOCENTE: "+evaluacionEntity.getNombreCordinador());
            System.out.println("CONCEPTO: "+evaluacionEntity.getConcepto());
            System.out.println("FECHA: "+evaluacionEntity.getFechaRegistroConcepto());
        }
    }
}
