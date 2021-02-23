package noetic.example.codetest.serviceImpl;

import noetic.example.codetest.constant.Constant;
import noetic.example.codetest.dto.EmployeeDto;
import noetic.example.codetest.exceptions.DepartmentNotFoundException;
import noetic.example.codetest.exceptions.EmployeeAlreadyInADepartment;
import noetic.example.codetest.exceptions.EmployeeNotFoundException;
import noetic.example.codetest.model.Department;
import noetic.example.codetest.model.Employee;
import noetic.example.codetest.repository.DepartmentRepo;
import noetic.example.codetest.repository.EmployeeRepo;
import noetic.example.codetest.serviceInterfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 1:01 PM
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    private TransformServiceImpl transformService;

    @Override
    public EmployeeDto saveEmployee(String deptId, EmployeeDto employeeDto) throws ClassNotFoundException {
        if (departmentRepo.findById(Long.valueOf(deptId)).isPresent()) {
            Department department = departmentRepo.findById(Long.valueOf(deptId)).get();

            Employee employee1 = employeeRepo.findEmployeeByEmployeeNum(employeeDto.getEmployeeNum());
            if (employee1 != null) {
                throw new EmployeeAlreadyInADepartment();
            }
            Employee employee = (Employee) transformService.convertToEntity(employeeDto, Constant.EMPLOYEE_ENTITY_CLASS);
            employee.setDepartment(department);
            return (EmployeeDto) transformService.convertToDto(employeeRepo.save(employee), Constant.EMPLOYEE_DTO_CLASS);
        } else {
            throw new DepartmentNotFoundException();
        }
    }

    @Override
    public List<EmployeeDto> findAllEmployees() throws ClassNotFoundException {
        return (List<EmployeeDto>) transformService.convertToDtoList(employeeRepo.findAll(), Constant.EMPLOYEE_DTO_CLASS);
    }

    @Override
    public EmployeeDto updateEmployee(String deptId, EmployeeDto employeeDto) throws ClassNotFoundException {
        if (departmentRepo.findById(Long.valueOf(deptId)).isPresent()) {
            if (employeeRepo.findById(employeeDto.getId()).isPresent()) {
                Department department = departmentRepo.findById(Long.valueOf(deptId)).get();
                Employee employee1 = employeeRepo.findById(employeeDto.getId()).get();
                employee1.setEmployeeNum(employeeDto.getEmployeeNum());
                employee1.setFirstName(employeeDto.getFirstName());
                employee1.setLastName(employeeDto.getLastName());
                employee1.setDepartment(department);
                return (EmployeeDto) transformService.convertToDto(employeeRepo.saveAndFlush(employee1), Constant.EMPLOYEE_DTO_CLASS);
            } else {
                throw new EmployeeNotFoundException();
            }
        } else {
            throw new DepartmentNotFoundException();
        }

    }

    @Override
    public EmployeeDto findById(Long id) throws ClassNotFoundException {
        if (employeeRepo.findById(Long.valueOf(id)).isPresent()) {
            return (EmployeeDto) transformService.convertToDto(employeeRepo.findById(id).get(), Constant.EMPLOYEE_DTO_CLASS);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public String deleteEmployee(Long id) {
        if (employeeRepo.findById(id).isPresent()) {
            employeeRepo.deleteById(id);
            return "Employee " + id + " deleted sucssesfully";
        } else {
            throw new EmployeeNotFoundException();
        }
    }
}
