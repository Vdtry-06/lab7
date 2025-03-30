package lab7.com.spring_boot.controller;

import lab7.com.spring_boot.dto.ApiResponse;
import lab7.com.spring_boot.dto.request.RolePermissionRequest;
import lab7.com.spring_boot.dto.response.PermissionResponse;
import lab7.com.spring_boot.dto.response.RolePermissionResponse;
import lab7.com.spring_boot.dto.response.RoleResponse;
import lab7.com.spring_boot.service.RolePermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RolePermissionController {
    RolePermissionService rolePermissionService;

    @GetMapping("/role-permissions")
    public ApiResponse<List<RolePermissionResponse>> getAllRolePermissions() {
        return ApiResponse.<List<RolePermissionResponse>>builder()
                .data(rolePermissionService.getAllRolePermissions())
                .build();
    }

    @GetMapping("/role-permissions/{roleId}/{permissionId}")
    public ApiResponse<RolePermissionResponse> getRolePermissionById(@PathVariable Long roleId, @PathVariable Long permissionId) {
        return ApiResponse.<RolePermissionResponse>builder()
                .data(rolePermissionService.getRolePermissionById(roleId, permissionId))
                .build();
    }


    @PostMapping("/role-permissions")
    public ApiResponse<RolePermissionResponse> addRolePermission(@RequestBody RolePermissionRequest request) {
        return ApiResponse.<RolePermissionResponse>builder()
                .data(rolePermissionService.addRolePermission(request))
                .build();
    }

    @DeleteMapping("/role-permissions/{roleId}/{permissionId}")
    public ApiResponse<Void> deleteRolePermissionById(@PathVariable Long roleId, @PathVariable Long permissionId) {
        rolePermissionService.deleteRolePermissionById(roleId, permissionId);
        return ApiResponse.<Void>builder()
                .message("Role permission deleted")
                .build();
    }

    @GetMapping("/roles/{roleId}/permissions")
    public ApiResponse<List<PermissionResponse>> getPermissionsByRoleId(@PathVariable Long roleId) {
        return ApiResponse.<List<PermissionResponse>>builder()
                .data(rolePermissionService.getPermissionsByRoleId(roleId))
                .build();
    }

    @GetMapping("/permissions/{permissionId}/roles")
    public ApiResponse<List<RoleResponse>> getRolesByPermissionId(@PathVariable Long permissionId) {
        return ApiResponse.<List<RoleResponse>>builder()
                .data(rolePermissionService.getRolesByPermissionId(permissionId))
                .build();
    }

}
