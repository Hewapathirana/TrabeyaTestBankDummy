package noetic.example.codetest.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 7:47 PM
 */

@NoArgsConstructor
@Data
public class ExceptionResponse {

    private String message;
    private int code;
    private Object data;

    public ExceptionResponse(String message, int code, Object data) {
        super();
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
