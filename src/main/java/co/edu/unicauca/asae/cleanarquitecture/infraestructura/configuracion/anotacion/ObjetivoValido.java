package co.edu.unicauca.asae.cleanarquitecture.infraestructura.configuracion.anotacion;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.configuracion.validadores.ObjetivoValidoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ObjetivoValidoValidator.class)
@Documented
public @interface ObjetivoValido {
    String message() default "El objetivo debe comenzar con un verbo en infinitivo (ej. 'Desarrollar', 'Implementar', 'Mejorar')";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
