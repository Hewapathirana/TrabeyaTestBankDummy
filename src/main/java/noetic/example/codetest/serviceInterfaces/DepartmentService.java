package noetic.example.codetest.serviceInterfaces;


import noetic.example.codetest.dto.DepartmentDto;
import noetic.example.codetest.model.Department;
import org.springframework.stereotype.Service;

/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 1:00 PM
 */
@Service
public interface DepartmentService {
    DepartmentDto saveDept(DepartmentDto departmentDto) throws ClassNotFoundException;
}
