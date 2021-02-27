package noetic.example.codetest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Created by DS hewapathirana.
 * Date:25/02/2020
 * Time: 7:45 PM
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BankException extends RuntimeException{
    public BankException(String message) {
        super(message);
    }

    public BankException(String message, Throwable cause) {
        super(message, cause);
    }


}
