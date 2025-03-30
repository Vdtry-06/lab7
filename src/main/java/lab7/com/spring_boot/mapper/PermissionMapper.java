package lab7.com.spring_boot.mapper;

import lab7.com.spring_boot.dto.request.PermissionRequest;
import lab7.com.spring_boot.dto.response.PermissionResponse;
import lab7.com.spring_boot.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
