package lab7.com.spring_boot.service;

import lab7.com.spring_boot.dto.request.EmployeeRequest;
import lab7.com.spring_boot.dto.response.EmployeeResponse;
import lab7.com.spring_boot.entity.Employee;
import lab7.com.spring_boot.mapper.EmployeeMapper;
import lab7.com.spring_boot.repository.EmployeeRepository;
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
public class EmployeeService {
    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;

    public EmployeeResponse addEmployee(EmployeeRequest request) {
        Employee employee = employeeMapper.toEmployee(request);
        employeeRepository.save(employee);
        return employeeMapper.toEmployeeResponse(employee);
    }

    public EmployeeResponse updateEmployee(Long id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        if (request.getFirstName() != null && !employee.getFirstName().equals(request.getFirstName())) {
            employee.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null && !employee.getLastName().equals(request.getLastName())) {
            employee.setLastName(request.getLastName());
        }
        if (request.getDateOfBirth() != null && !employee.getDateOfBirth().equals(request.getDateOfBirth())) {
            employee.setDateOfBirth(request.getDateOfBirth());
        }
        if (request.getPhoneNumber() != null && !employee.getPhoneNumber().equals(request.getPhoneNumber())) {
            employee.setPhoneNumber(request.getPhoneNumber());
        }
        if (request.getAddress() != null && !employee.getAddress().equals(request.getAddress())) {
            employee.setAddress(request.getAddress());
        }
        if (request.getHireDate() != null && !employee.getHireDate().equals(request.getHireDate())) {
            employee.setHireDate(request.getHireDate());
        }
        if (request.getSalary() != null && !employee.getSalary().equals(request.getSalary())) {
            employee.setSalary(request.getSalary());
        }
        if (request.getStatus() != null && !employee.getStatus().equals(request.getStatus())) {
            employee.setStatus(request.getStatus());
        }
        employeeRepository.save(employee);
        return employeeMapper.toEmployeeResponse(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        employeeRepository.delete(employee);
    }

    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::toEmployeeResponse).toList();
    }

    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        return employeeMapper.toEmployeeResponse(employee);
    }
}
