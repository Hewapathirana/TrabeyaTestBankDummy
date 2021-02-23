package noetic.example.codetest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 7:45 PM
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = DepartmentNotFoundException.class)
    public ResponseEntity<Object> DeptIdNotFoundException(Throwable ex) {
        return new ResponseEntity<>(new ExceptionResponse("Department not found.Please add a Department first",404,ex), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<Object> EmployeeNotFound(Throwable ex) {
        return new ResponseEntity<>(new ExceptionResponse("Employee Not Found",404,ex), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmployeeAlreadyInADepartment.class)
    public ResponseEntity<Object> EmployeeAlreadyInADepartment(Throwable ex) {
        return new ResponseEntity<>(new ExceptionResponse("Employee Is Already has a department",404,ex), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BankAccountNotFound.class)
    public ResponseEntity<Object> BankAccNotFound(Throwable ex) {
        return new ResponseEntity<>(new ExceptionResponse("Bank Account not Found",404,null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BankException.class)
    public ResponseEntity<Object> BankExceptionCommon(Throwable ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(),400,null), HttpStatus.BAD_REQUEST);
    }

}
