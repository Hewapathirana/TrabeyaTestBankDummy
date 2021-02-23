package noetic.example.codetest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 10:26 AM
 */
@Getter
@Setter
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Department name is required")
    private String name;

    private  String departmentId;

     @JsonIgnore
    @OneToMany(
            mappedBy = "department"
            , fetch = FetchType.LAZY)

    private List<Employee> employee;


}
