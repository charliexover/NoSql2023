package tecno.nosql2023.model.excepcionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExcepcionCustom.class)
    public ResponseEntity<Object> handleCustomRuntimeException(ExcepcionCustom ex) {
        ErrorResponse errorResponse = new ErrorResponse("Error", ex.getMessage());
        HttpStatus httpStatus = ex.getHttpStatus(); // Obtener el HttpStatus de la excepción
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
