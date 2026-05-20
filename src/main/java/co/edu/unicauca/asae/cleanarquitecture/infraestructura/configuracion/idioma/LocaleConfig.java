package co.edu.unicauca.asae.cleanarquitecture.infraestructura.configuracion.idioma;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class LocaleConfig extends AcceptHeaderLocaleResolver {
    @Bean
    public LocaleResolver localeResolver(){
        AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
        resolver.setDefaultLocale(new Locale("es"));
        return resolver;
    }
}
