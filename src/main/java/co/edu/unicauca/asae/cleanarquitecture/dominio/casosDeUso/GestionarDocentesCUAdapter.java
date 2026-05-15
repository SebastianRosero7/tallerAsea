package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarDocentesCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.mappers.DocenteMapper;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GestionarDocentesCUAdapter implements GestionarDocentesCUIntPort {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private DocenteMapper docenteMapper;

    @Override
    public DocenteDTORespuesta crear(DocenteDTOPeticion docente) {
        DocenteEntity entity = docenteMapper.toEntity(docente);
        DocenteEntity guardado = docenteRepository.save(entity);
        return docenteMapper.toDTORespuesta(guardado);
    }

    @Override
    public Collection<DocenteDTORespuesta> listarDocentes(String nombreGrupo, String patron) {
        if(nombreGrupo != null || patron != null){
            List<DocenteEntity> docentes = docenteRepository.findByNombreGrupoAndApellidosStartingWithIgnoreCase(nombreGrupo, patron);
            return docentes.isEmpty() ? List.of() : docentes.stream()
                    .map(docenteMapper::toDTORespuesta)
                    .toList();
        }
        return docenteRepository.findAll().stream()
                .map(docenteMapper::toDTORespuesta)
                .toList();
    }

    @Override
    public DocenteDTORespuesta findById(Long id) {
        return docenteRepository.findById(id)
                .map(docenteMapper::toDTORespuesta)
                .orElse(null);
    }
}
