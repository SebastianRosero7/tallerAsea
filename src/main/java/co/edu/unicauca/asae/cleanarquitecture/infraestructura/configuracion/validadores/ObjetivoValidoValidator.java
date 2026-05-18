package co.edu.unicauca.asae.cleanarquitecture.infraestructura.configuracion.validadores;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.configuracion.anotacion.ObjetivoValido;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validador personalizado para la anotación @ObjetivoValido.
 * Valida que un objetivo comience con un verbo en infinitivo.
 * 
 * Los verbos en infinitivo en español terminan en: -ar, -er, -ir
 * Ejemplos válidos: "Desarrollar...", "Implementar...", "Crear...", "Mejorar...", "Evaluar..."
 */
public class ObjetivoValidoValidator implements ConstraintValidator<ObjetivoValido, String> {

    @Override
    public void initialize(ObjetivoValido constraintAnnotation) {
        // Sin inicialización necesaria
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        // Si es null, permitir
        if (value == null || value.trim().isEmpty()) {
            return true;
        }
        
        // Obtener la primera palabra (hasta el primer espacio)
        String[] palabras = value.trim().split("\\s+");
        if (palabras.length == 0) {
            return false;
        }
        
        String primerPalabra = palabras[0].toLowerCase();
        
        // Validar que termine en -ar, -er o -ir
        // Los verbos en infinitivo siempre terminan en uno de estos sufijos
        return primerPalabra.endsWith("ar") 
            || primerPalabra.endsWith("er") 
            || primerPalabra.endsWith("ir");
    }
}
