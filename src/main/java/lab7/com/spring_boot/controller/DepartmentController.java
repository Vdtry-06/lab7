package lab7.com.spring_boot.controller;

import lab7.com.spring_boot.dto.ApiResponse;
import lab7.com.spring_boot.dto.request.DepartmentRequest;
import lab7.com.spring_boot.dto.response.DepartmentResponse;
import lab7.com.spring_boot.service.DepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class DepartmentController {
    DepartmentService departmentService;

    @PostMapping
    public ApiResponse<DepartmentResponse> addDepartment(@RequestBody DepartmentRequest request) {
        return ApiResponse.<DepartmentResponse>builder()
                .message("added department Successfully")
                .data(departmentService.addDepartment(request))
                .build();
    }

    @PutMapping("{id}")
    public ApiResponse<DepartmentResponse> updateDepartment(@PathVariable Long id, @RequestBody DepartmentRequest request) {
        return ApiResponse.<DepartmentResponse>builder()
                .message("update id department Successfully")
                .data(departmentService.updateDepartment(id, request))
                .build();
    }

    @DeleteMapping("{id}")
    public ApiResponse<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ApiResponse.<Void>builder()
                .message("Deleted id department successfully")
                .build();
    }

    @GetMapping
    public ApiResponse<List<DepartmentResponse>> getAllDepartments() {
        return ApiResponse.<List<DepartmentResponse>>builder()
                .message("get all departments Successfully")
                .data(departmentService.getAllDepartments())
                .build();
    }

    @GetMapping("{id}")
    public ApiResponse<DepartmentResponse> getDepartmentById(@PathVariable Long id) {
        return ApiResponse.<DepartmentResponse>builder()
                .message("get id department Successfully")
                .data(departmentService.getDepartmentById(id))
                .build();
    }
}