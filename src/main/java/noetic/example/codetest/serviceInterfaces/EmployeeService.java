package noetic.example.codetest.serviceInterfaces;

import noetic.example.codetest.dto.EmployeeDto;
import noetic.example.codetest.model.Employee;

import java.util.List;

/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 1:00 PM
 */
public interface EmployeeService {


    EmployeeDto saveEmployee(String deptId, EmployeeDto employeeDto) throws ClassNotFoundException ;

    List<EmployeeDto> findAllEmployees() throws ClassNotFoundException;

    EmployeeDto updateEmployee(String deptId,EmployeeDto employeeDto) throws ClassNotFoundException;

    EmployeeDto findById(Long id) throws ClassNotFoundException;

    String deleteEmployee(Long id);
}
