package noetic.example.codetest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by DS hewapathirana.
 * Date: 9/23/2019
 * Time: 10:01 AM
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class EmployeeNotFoundException extends RuntimeException {
}
