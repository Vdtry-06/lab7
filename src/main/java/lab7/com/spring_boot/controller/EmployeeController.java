package lab7.com.spring_boot.controller;

import lab7.com.spring_boot.dto.ApiResponse;
import lab7.com.spring_boot.dto.request.EmployeeRequest;
import lab7.com.spring_boot.dto.response.EmployeeResponse;
import lab7.com.spring_boot.service.EmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class EmployeeController {
    EmployeeService employeeService;

    @PostMapping
    public ApiResponse<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest request) {
        return ApiResponse.<EmployeeResponse>builder()
                .message("Successfully added employee")
                .data(employeeService.addEmployee(request))
                .build();
    }

    @PutMapping("{id}")
    public ApiResponse<EmployeeResponse> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest request) {
        return ApiResponse.<EmployeeResponse>builder()
                .message("Employee updated")
                .data(employeeService.updateEmployee(id, request))
                .build();
    }

    @DeleteMapping("{id}")
    public ApiResponse<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ApiResponse.<Void>builder()
                .message("Employee deleted Successfully")
                .build();
    }

    @GetMapping("{id}")
    public ApiResponse<EmployeeResponse> getEmployeeById(@PathVariable Long id) {
        return ApiResponse.<EmployeeResponse>builder()
                .message("Employee found")
                .data(employeeService.getEmployeeById(id))
                .build();
    }

    @GetMapping
    public ApiResponse<List<EmployeeResponse>> getEmployees() {
        return ApiResponse.<List<EmployeeResponse>>builder()
                .message("Employee list Successfully")
                .data(employeeService.getAllEmployees())
                .build();
    }
}
