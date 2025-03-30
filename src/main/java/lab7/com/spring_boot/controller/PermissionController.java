package lab7.com.spring_boot.controller;

import lab7.com.spring_boot.dto.ApiResponse;
import lab7.com.spring_boot.dto.request.PermissionRequest;
import lab7.com.spring_boot.dto.response.PermissionResponse;
import lab7.com.spring_boot.entity.Permission;
import lab7.com.spring_boot.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PermissionController {
    PermissionService permissionService;

    @PostMapping
    public ApiResponse<PermissionResponse> addPermission(@RequestBody PermissionRequest request) {
        return ApiResponse.<PermissionResponse>builder()
                .message("Permission added successfully")
                .data(permissionService.addPermission(request))
                .build();
    }

    @PutMapping("{id}")
    public ApiResponse<PermissionResponse> updatePermission(@PathVariable Long id, @RequestBody PermissionRequest request) {
        return ApiResponse.<PermissionResponse>builder()
                .message("Permission updated successfully")
                .data(permissionService.updatePermission(id,request))
                .build();
    }

    @DeleteMapping("{id}")
    public ApiResponse<PermissionResponse> deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
        return ApiResponse.<PermissionResponse>builder()
                .message("Permission deleted successfully")
                .build();
    }

    @GetMapping
    public ApiResponse<List<PermissionResponse>> getAllPermissions() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .message("All permissions found")
                .data(permissionService.getAllPermissions())
                .build();
    }

    @GetMapping("{id}")
    public ApiResponse<PermissionResponse> getPermission(@PathVariable Long id) {
        return ApiResponse.<PermissionResponse>builder()
                .message("Permission found")
                .data(permissionService.getPermissionById(id))
                .build();
    }
}
