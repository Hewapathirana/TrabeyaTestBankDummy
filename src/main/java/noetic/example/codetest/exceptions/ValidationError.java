package noetic.example.codetest.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by DS hewapathirana.
 * Date:25/02/2020
 * Time: 8:45 PM
 */
@Getter
@Setter
public class ValidationError {
    private String path;
    private String message;
}
