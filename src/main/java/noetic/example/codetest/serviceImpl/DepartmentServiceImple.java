package noetic.example.codetest.serviceImpl;

import noetic.example.codetest.constant.Constant;
import noetic.example.codetest.dto.DepartmentDto;
import noetic.example.codetest.model.Department;
import noetic.example.codetest.repository.DepartmentRepo;
import noetic.example.codetest.serviceInterfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 1:01 PM
 */

@Service
public class DepartmentServiceImple implements DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    private TransformServiceImpl transformService;


    @Override
    public DepartmentDto saveDept(DepartmentDto departmentDto) throws ClassNotFoundException   {

        Department department = (Department) transformService.convertToEntity(departmentDto, Constant.DEPARTMENT_ENTITY_CLASS);

       return (DepartmentDto) transformService.convertToDto(departmentRepo.save(department), Constant.DEPARTMENT_DTO_CLASS);
//      return  departmentRepo.save(department);
    }

}
