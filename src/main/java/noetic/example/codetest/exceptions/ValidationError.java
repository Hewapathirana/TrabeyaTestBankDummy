package noetic.example.codetest.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by DS hewapathirana.
 * Date: 9/23/2019
 * Time: 10:41 PM
 */
@Getter
@Setter
public class ValidationError {
    private String path;
    private String message;
}
