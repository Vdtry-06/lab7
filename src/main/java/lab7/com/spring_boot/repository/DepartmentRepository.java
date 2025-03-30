package lab7.com.spring_boot.repository;

import lab7.com.spring_boot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
