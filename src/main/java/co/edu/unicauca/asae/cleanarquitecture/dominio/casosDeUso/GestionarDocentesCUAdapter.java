package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;

import java.util.Collection;
import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.FormatoADTORespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarDocentesCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarDocentesGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers.DocenteMapper;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;

@Service
public class GestionarDocentesCUAdapter implements GestionarDocentesCUIntPort {

    @Autowired
    private GestionarDocentesGatewayIntPort docentesGatewayIntPort;

    @Autowired
    private DocenteMapper docenteMapper;

    @Override
    public DocenteDTORespuesta crear(DocenteDTOPeticion docente) {
        DocenteEntity entity = docenteMapper.toEntity(docente);
        if(docentesGatewayIntPort.correoDocenteExiste(entity.getCorreo()) == 1){
            throw new ResponseStatusException(HttpStatus.CONFLICT ,"correo duplicado");
        }
        
        DocenteEntity guardado = docentesGatewayIntPort.guardar(entity);
        return docenteMapper.toDTORespuesta(guardado);
    }

    @Override
    public Collection<DocenteDTORespuesta> listarDocentes(String nombreGrupo, String patron, String nombreDocente) {
        if(nombreGrupo != null || patron != null){
            List<DocenteEntity> docentes = docentesGatewayIntPort.listarDocenteByGrupo(nombreGrupo, patron);
            return docentes.isEmpty() ? List.of() : docentes.stream()
                    .map(docenteMapper::toDTORespuesta)
                    .toList();
        } else if (nombreDocente != null) {
            List<DocenteEntity> docentes = docentesGatewayIntPort.listarFormatosAByDocente(nombreDocente);
            return docentes.isEmpty() ? List.of() : docentes.stream()
                    .map(docenteMapper::toDTORespuesta)
                    .toList();
            
        }
        return docentesGatewayIntPort.listarTodo().stream()
                .map(docenteMapper::toDTORespuesta)
                .toList();
    }

    

    @Override
    public DocenteDTORespuesta findById(Long id) {
        return docentesGatewayIntPort.docenteById(id)
                .map(docenteMapper::toDTORespuesta)
                .orElse(null);
    }
}
