package lab7.com.spring_boot.service;

import lab7.com.spring_boot.dto.request.RolePermissionRequest;
import lab7.com.spring_boot.dto.response.PermissionResponse;
import lab7.com.spring_boot.dto.response.RolePermissionResponse;
import lab7.com.spring_boot.dto.response.RoleResponse;
import lab7.com.spring_boot.entity.Permission;
import lab7.com.spring_boot.entity.Role;
import lab7.com.spring_boot.entity.RolePermission;
import lab7.com.spring_boot.mapper.PermissionMapper;
import lab7.com.spring_boot.mapper.RoleMapper;
import lab7.com.spring_boot.mapper.RolePermissionMapper;
import lab7.com.spring_boot.repository.PermissionRepository;
import lab7.com.spring_boot.repository.RolePermissionRepository;
import lab7.com.spring_boot.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RolePermissionService {
    RolePermissionRepository rolePermissionRepository;
    RolePermissionMapper rolePermissionMapper;
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;
    PermissionMapper permissionMapper;

    public List<RolePermissionResponse> getAllRolePermissions() {
        List<RolePermission> rolePermissions = rolePermissionRepository.findAll();
        return rolePermissions.stream()
                .map(rolePermissionMapper::toRolePermissionResponse)
                .toList();
    }

    public RolePermissionResponse getRolePermissionById(Long roleId, Long permissionId) {
        RolePermission rolePermission = rolePermissionRepository.findByRoleIdAndPermissionId(roleId, permissionId)
                .orElseThrow(() -> new IllegalArgumentException("Role Permission Not Found"));
        return rolePermissionMapper.toRolePermissionResponse(rolePermission);
    }


    @Transactional
    public RolePermissionResponse addRolePermission(RolePermissionRequest rolePermissionRequest) {
        Role role = roleRepository.findById(rolePermissionRequest.getRoleId())
                .orElseThrow(() -> new IllegalArgumentException("Role Not Found"));
        Permission permission = permissionRepository.findById(rolePermissionRequest.getPermissionId())
                .orElseThrow(() -> new IllegalArgumentException("Permission Not Found"));
        if (rolePermissionRepository.findByRoleIdAndPermissionId(role.getId(), permission.getId()).isPresent()) {
            throw new IllegalArgumentException("Role Permission Already Exists");
        }

        RolePermission rolePermission = RolePermission.builder()
                .role(role)
                .permission(permission)
                .build();

        rolePermissionRepository.save(rolePermission);
        return rolePermissionMapper.toRolePermissionResponse(rolePermission);
    }

    @Transactional
    public void deleteRolePermissionById(Long roleId, Long permissionId) {
        RolePermission rolePermission = rolePermissionRepository.findByRoleIdAndPermissionId(roleId, permissionId)
                .orElseThrow(() -> new IllegalArgumentException("Role Permission Not Found"));
        rolePermissionRepository.delete(rolePermission);
    }

    public List<PermissionResponse> getPermissionsByRoleId(Long roleId) {
        roleRepository.findById(roleId).orElseThrow(() -> new IllegalArgumentException("Role Not Found"));

        List<RolePermission> rolePermissions = rolePermissionRepository.findByRoleId(roleId);
        return rolePermissions.stream()
                .map(request -> permissionMapper.toPermissionResponse(request.getPermission()))
                .toList();
    }

    public List<RoleResponse> getRolesByPermissionId(Long permissionId) {
        permissionRepository.findById(permissionId)
                .orElseThrow(() -> new IllegalArgumentException("Permission Not Found"));
        List<RolePermission> rolePermissions = rolePermissionRepository.findByPermissionId(permissionId);
        return rolePermissions.stream()
                .map(request -> roleMapper.toRoleResponse(request.getRole()))
                .toList();
    }
}
