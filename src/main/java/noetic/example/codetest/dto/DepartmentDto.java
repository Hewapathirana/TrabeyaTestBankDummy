package noetic.example.codetest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import noetic.example.codetest.model.Employee;

import java.util.List;

/**
 * Created by DS hewapathirana.
 * Date: 9/23/2019
 * Time: 6:52 PM
 */
@Getter
@Setter
public class DepartmentDto {


    private Long id;
    private String name;
    private  String departmentId;

    @JsonIgnore
    private List<Employee> employee;

}
