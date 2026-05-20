package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.mappers;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.HistoricoDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.HistoricoDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.RolDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.HistoricoEntity;

public class HistoricoMapper {
    public HistoricoEntity toEntity(HistoricoDTOPeticion historico){
        HistoricoEntity historicoEntity = new HistoricoEntity();
        //no pasamos el id
        historicoEntity.setActivo(historico.getActivo());
        //historicoEntity.setFechaInicio(historico.getFechaInicio());
        //historicoEntity.setFechaFin(historico.getFechaFin());
        return historicoEntity;
    }

    public HistoricoDTORespuesta toDTO(HistoricoEntity historico){
        HistoricoDTORespuesta historicoDTO = new HistoricoDTORespuesta();
        historicoDTO.setIdHistorico(historico.getIdHistorico());
        historicoDTO.setActivo(historico.getActivo());
        historicoDTO.setFechaInicio(historico.getFechaInicio() == null ? null : historico.getFechaInicio().toString());
        historicoDTO.setFechaFin(historico.getFechaFin() == null ? null : historico.getFechaFin().toString());
        historicoDTO.setObjRol(historico.getObjRol() == null ? null : new RolDTORespuesta(historico.getObjRol().getRoleAsignado()));
        historicoDTO.setObjDocente(historico.getObjDocente() == null ? null : historico.getObjDocente().getIdDocente());
        return historicoDTO;
    }
}
