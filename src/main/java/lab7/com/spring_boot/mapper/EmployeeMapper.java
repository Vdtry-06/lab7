package lab7.com.spring_boot.mapper;

import lab7.com.spring_boot.dto.request.EmployeeRequest;
import lab7.com.spring_boot.dto.response.EmployeeResponse;
import lab7.com.spring_boot.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEmployee(EmployeeRequest request);

    EmployeeResponse toEmployeeResponse(Employee employee);
}
