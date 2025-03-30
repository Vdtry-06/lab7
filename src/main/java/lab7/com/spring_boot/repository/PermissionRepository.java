package lab7.com.spring_boot.repository;

import lab7.com.spring_boot.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
