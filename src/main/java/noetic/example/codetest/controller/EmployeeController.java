package noetic.example.codetest.controller;

import noetic.example.codetest.dto.EmployeeDto;
import noetic.example.codetest.model.Employee;
import noetic.example.codetest.serviceImpl.MapValidationErrorService;
import noetic.example.codetest.serviceInterfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 10:39 AM
 */

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    EmployeeService employeeService;

    /*[ BindingResult ] is Spring's object that holds the result of the validation
    and binding and contains errors that may have occurred. The BindingResult must
    come right after the model object that is validated or else Spring will fail to
    validate the object and throw an exception.*/

    @PostMapping("/employee/{deptId}")
    public ResponseEntity<?> addEmployee(@PathVariable(name = "deptId") String deptId,@Valid @RequestBody EmployeeDto employeeDto,
                                         BindingResult result) throws ClassNotFoundException {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;
        return   ResponseEntity.ok(employeeService.saveEmployee(deptId,employeeDto));

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) throws ClassNotFoundException{
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping("employees")
    public ResponseEntity<?> getEmployees() throws ClassNotFoundException{
        return ResponseEntity.ok(employeeService.findAllEmployees());

    }

    @DeleteMapping("/employee/{emid}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(name = "emid") Long emid){
        return ResponseEntity.ok(employeeService.deleteEmployee(emid));
    }


    @PutMapping("employee/{deptId}")
    public ResponseEntity<?> updateEmployee(@PathVariable(name = "deptId") String deptId,@RequestBody EmployeeDto employeeDto) throws ClassNotFoundException{
        return   ResponseEntity.ok(employeeService.updateEmployee(deptId,employeeDto));

    }



}
