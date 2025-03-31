package lab7.com.spring_boot.repository;

import lab7.com.spring_boot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByPositionId(Long positionId);
}
