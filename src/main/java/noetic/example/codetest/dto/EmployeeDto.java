package noetic.example.codetest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noetic.example.codetest.model.Department;

import javax.validation.constraints.NotBlank;

/**
 * Created by DS hewapathirana.
 * Date: 9/23/2019
 * Time: 6:53 PM
 */
@Getter
@Setter
public class EmployeeDto {
    private Long id;

    @NotBlank(message = "Employee first name is required")
    private String firstName;

    private String lastName;

    @NotBlank(message = "EmployeeNUM first name is required")
    private String employeeNum;

    private Department department;
}
