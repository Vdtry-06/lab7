package lab7.com.spring_boot.repository;

import lab7.com.spring_boot.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermission.RolePermissionId> {
    Optional<RolePermission> findByRoleIdAndPermissionId(Long roleId, Long permissionId);
    List<RolePermission> findByRoleId(Long roleId);
    List<RolePermission> findByPermissionId(Long permissionId);
}
