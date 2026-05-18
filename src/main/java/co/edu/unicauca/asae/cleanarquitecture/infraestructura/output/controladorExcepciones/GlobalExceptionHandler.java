package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.controladorExcepciones;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta.ErrorDTOResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import java.time.Instant;
import java.util.NoSuchElementException;

/**
 * Handler global de excepciones para la API.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTOResponse> handleValidation(MethodArgumentNotValidException ex, WebRequest request) {
        StringBuilder sb = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(err -> sb.append(err.getField()).append(": ").append(err.getDefaultMessage()).append("; "));
        String path = extractPath(request.getDescription(false));
        ErrorDTOResponse error = new ErrorDTOResponse(Instant.now(), HttpStatus.BAD_REQUEST.value(), "Validation Failed", sb.toString(), path);
        logger.warn("Validacion fallida: {}", sb.toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ErrorDTOResponse> handleNotFound(RuntimeException ex, WebRequest request) {
        String path = extractPath(request.getDescription(false));
        ErrorDTOResponse error = new ErrorDTOResponse(Instant.now(), HttpStatus.NOT_FOUND.value(), "Not Found", ex.getMessage(), path);
        logger.info("Recurso no encontrado: {}", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorDTOResponse> handleDataAccess(DataAccessException ex, WebRequest request) {
        String msg = ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage();
        String path = extractPath(request.getDescription(false));
        ErrorDTOResponse error = new ErrorDTOResponse(Instant.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Database Error", msg, path);
        logger.error("Error en la base de datos", ex);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTOResponse> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {
        String path = extractPath(request.getDescription(false));
        ErrorDTOResponse error = new ErrorDTOResponse(Instant.now(), HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getMessage(), path);
        logger.warn("Solicitud incorrecta: {}", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTOResponse> handleAll(Exception ex, WebRequest request) {
        String path = extractPath(request.getDescription(false));
        ErrorDTOResponse error = new ErrorDTOResponse(Instant.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", ex.getMessage(), path);
        logger.error("Error inesperado", ex);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String extractPath(String description) {
        if (description == null) return "";
        // WebRequest#getDescription(false) suele devolver "uri=/..." → extraer la parte después de '='
        int idx = description.indexOf('=');
        if (idx >= 0 && idx + 1 < description.length()) {
            return description.substring(idx + 1);
        }
        return description;
    }
}


