package lab7.com.spring_boot.mapper;

import lab7.com.spring_boot.dto.request.DepartmentRequest;
import lab7.com.spring_boot.dto.response.DepartmentResponse;
import lab7.com.spring_boot.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toDepartment(DepartmentRequest request);

    DepartmentResponse toDepartmentResponse(Department department);
}
