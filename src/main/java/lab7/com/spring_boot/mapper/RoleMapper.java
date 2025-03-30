package lab7.com.spring_boot.mapper;

import lab7.com.spring_boot.dto.request.RoleRequest;
import lab7.com.spring_boot.dto.response.RoleResponse;
import lab7.com.spring_boot.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
}
