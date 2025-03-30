package lab7.com.spring_boot.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequest {
    String firstName;
    String lastName;
    Date dateOfBirth;
    String phoneNumber;
    String address;
    Date hireDate;
    Float salary;
    String status;
}
