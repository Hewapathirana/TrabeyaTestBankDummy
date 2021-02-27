package noetic.example.codetest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by DS hewapathirana.
 * Date:25/02/2020
 * Time: 7:45 PM
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = BankException.class)
    public ResponseEntity<Object> BankExceptionCommon(Throwable ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(),400,null), HttpStatus.BAD_REQUEST);
    }

}
