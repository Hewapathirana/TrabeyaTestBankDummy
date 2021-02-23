package noetic.example.codetest.controller;

import noetic.example.codetest.dto.DepartmentDto;
import noetic.example.codetest.model.Department;
import noetic.example.codetest.repository.DepartmentRepo;
import noetic.example.codetest.serviceInterfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 2:55 PM
 */

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/department")
    public ResponseEntity<?> addDepartment(@RequestBody DepartmentDto departmentDto) throws ClassNotFoundException {

        return  new ResponseEntity<DepartmentDto>(departmentService.saveDept(departmentDto), HttpStatus.CREATED);

    }

}
