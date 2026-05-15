package co.edu.unicauca.asae.cleanarquitecture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EstadoEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoTIEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.DocenteRepository;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.FormatoTiRepository;
import jakarta.transaction.Transactional;


@Service
public class FormatoTIService {

    @Autowired
    private FormatoTiRepository repository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Transactional
	@ReadOnlyProperty
	public void crearFormatoTi(String titulo, String obj, String asesor, String est, String est2,Long idDoc){
		FormatoTIEntity f = new FormatoTIEntity();

        f.setTitulo("TI " + titulo);
        f.setObjetivoGeneral(obj);
        f.setObjetivosEspecificos("Específicos");

        DocenteEntity d = docenteRepository.findById(idDoc).orElse(null);

        EstadoEntity e = new EstadoEntity();

        f.setObjDocente(d);
        f.setObjEstado(e);
        e.setObjFormatoA(f);

        f.setNombreEstudiante1(est);
        f.setNombreEstudiante2(est2);

		repository.save(f);

	}

}
