package co.edu.unicauca.asae.cleanarquitecture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EstadoEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoPPEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.DocenteRepository;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.FormatoPPRepository;
import jakarta.transaction.Transactional;

@Service
public class FormatoPPService {

    @Autowired
    private FormatoPPRepository repository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Transactional
	@ReadOnlyProperty
	public void crearFormatoPP(String titulo, String obj, String asesor, String est, int idDoc){
		FormatoPPEntity f = new FormatoPPEntity();

        f.setTitulo("PP " + titulo);
        f.setObjetivoGeneral(obj);
        f.setObjetivosEspecificos("Específicos");

        DocenteEntity d = docenteRepository.findById(Long.parseLong(String.valueOf(idDoc))).orElse(null);

        EstadoEntity e = new EstadoEntity();

        f.setObjDocente(d);
        f.setObjEstado(e);
        e.setObjFormatoA(f);

        f.setNombreAsesor(asesor);
        f.setNombreEstudiante1(est);
        f.setRuta_carta_aceptacion("/ruta/test.pdf");

		repository.save(f);

	}

}
