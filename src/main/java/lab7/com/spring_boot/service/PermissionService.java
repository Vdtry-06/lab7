package lab7.com.spring_boot.service;

import lab7.com.spring_boot.dto.request.PermissionRequest;
import lab7.com.spring_boot.dto.response.PermissionResponse;
import lab7.com.spring_boot.entity.Permission;
import lab7.com.spring_boot.mapper.PermissionMapper;
import lab7.com.spring_boot.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse addPermission(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public PermissionResponse updatePermission(Long id, PermissionRequest request) {
        Permission permission = permissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Permission not found"));
        if (request.getName() != null && !request.getName().equals(permission.getName())) {
            permission.setName(request.getName());
        }
        if (request.getDescription() != null && !request.getDescription().equals(permission.getDescription())) {
            permission.setDescription(request.getDescription());
        }
        permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public void deletePermission(Long id) {
        Permission permission = permissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Permission not found"));
        permissionRepository.delete(permission);
    }

    public List<PermissionResponse> getAllPermissions() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public PermissionResponse getPermissionById(Long id) {
        Permission permission = permissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Permission not found"));
        return permissionMapper.toPermissionResponse(permission);
    }
}
