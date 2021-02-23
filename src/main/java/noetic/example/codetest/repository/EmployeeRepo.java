package noetic.example.codetest.repository;

import noetic.example.codetest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 11:00 AM
 */

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Employee findEmployeeByEmployeeNum(String empNum);

}
