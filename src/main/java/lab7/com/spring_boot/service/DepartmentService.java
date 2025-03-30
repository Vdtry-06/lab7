package lab7.com.spring_boot.service;

import lab7.com.spring_boot.dto.request.DepartmentRequest;
import lab7.com.spring_boot.dto.response.DepartmentResponse;
import lab7.com.spring_boot.entity.Department;
import lab7.com.spring_boot.mapper.DepartmentMapper;
import lab7.com.spring_boot.repository.DepartmentRepository;
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
public class DepartmentService {
    DepartmentRepository departmentRepository;
    DepartmentMapper departmentMapper;

    public DepartmentResponse addDepartment(DepartmentRequest request) {
        Department department = departmentMapper.toDepartment(request);
        departmentRepository.save(department);
        return departmentMapper.toDepartmentResponse(department);
    }

    public DepartmentResponse updateDepartment(Long id, DepartmentRequest request) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Department not found"));
        if (request.getName() != null && !request.getName().equals(department.getName())) {
            department.setName(request.getName());
        }
        if (request.getDescription() != null && !request.getDescription().equals(department.getDescription())) {
            department.setDescription(request.getDescription());
        }
        departmentRepository.save(department);
        return departmentMapper.toDepartmentResponse(department);
    }

    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Department not found"));
        departmentRepository.delete(department);
    }

    public List<DepartmentResponse> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(departmentMapper::toDepartmentResponse).toList();
    }

    public DepartmentResponse getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Department not found"));
        return departmentMapper.toDepartmentResponse(department);
    }

}
