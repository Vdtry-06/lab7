package lab7.com.spring_boot.service;

import lab7.com.spring_boot.dto.request.RoleRequest;
import lab7.com.spring_boot.dto.response.RoleResponse;
import lab7.com.spring_boot.entity.Role;
import lab7.com.spring_boot.mapper.RoleMapper;
import lab7.com.spring_boot.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;

    public RoleResponse addRole(RoleRequest request) {
        Role role = roleMapper.toRole(request);
        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public RoleResponse updateRole(Long id, RoleRequest request) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role not found"));
        if (request.getName() != null && !request.getName().equals(role.getName())) {
            role.setName(request.getName());
        }
        if (request.getDescription() != null && !request.getDescription().equals(role.getDescription())) {
            role.setDescription(request.getDescription());
        }
        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    public List<RoleResponse> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleResponse).toList();
    }

    public RoleResponse getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        return roleMapper.toRoleResponse(role);
    }
}
