package lab7.com.spring_boot.controller;

import lab7.com.spring_boot.dto.ApiResponse;
import lab7.com.spring_boot.dto.request.RoleRequest;
import lab7.com.spring_boot.dto.response.RoleResponse;
import lab7.com.spring_boot.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> addRole(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .message("Successfully added role")
                .data(roleService.addRole(request))
                .build();
    }

    @PutMapping("{id}")
    ApiResponse<RoleResponse> updateRole(@PathVariable Long id, @RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .message("Successfully updated role")
                .data(roleService.updateRole(id, request))
                .build();
    }

    @DeleteMapping("{id}")
    ApiResponse<RoleResponse> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ApiResponse.<RoleResponse>builder()
                .message("Successfully deleted roleId: " + id)
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAllRoles() {
        return ApiResponse.<List<RoleResponse>>builder()
                .message("Successfully retrieved all roles")
                .data(roleService.getAllRoles())
                .build();
    }

    @GetMapping("{id}")
    ApiResponse<RoleResponse> getRoleById(@PathVariable Long id) {
        return ApiResponse.<RoleResponse>builder()
                .message("Successfully retrieved roleId: " + id)
                .data(roleService.getRoleById(id))
                .build();
    }
}
