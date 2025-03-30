package lab7.com.spring_boot.mapper;

import lab7.com.spring_boot.dto.response.RolePermissionResponse;
import lab7.com.spring_boot.entity.RolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RolePermissionMapper {

    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "permission.id", target = "permissionId")
    @Mapping(source = "role.name", target = "roleName")
    @Mapping(source = "permission.name", target = "permissionName")
    RolePermissionResponse toRolePermissionResponse(RolePermission rolePermission);
}
