package lab7.com.spring_boot.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeePositionResponse {
    Long positionId;
    List<EmployeeResponse> employees;
}
