package noetic.example.codetest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 7:44 PM
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class DepartmentNotFoundException extends RuntimeException{
}
