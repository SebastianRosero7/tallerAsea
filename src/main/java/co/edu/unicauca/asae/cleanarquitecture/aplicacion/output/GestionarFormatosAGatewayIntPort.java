package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import java.util.Optional;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.FormatoAEntity;

public interface GestionarFormatosAGatewayIntPort {
    public FormatoAEntity guardar(FormatoAEntity formato);
    public boolean tituloFormatoExiste(String nombre);
    public FormatoAEntity obtenerReferencia(Long idFormato);
    public boolean existeFormatoId(Long idFormato);
    public Optional<FormatoAEntity> formatoADetalles(String titulo);
}
