package lab7.com.spring_boot.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long employeeId;
    String firstName;
    String lastName;
    Date dateOfBirth;
    String phoneNumber;
    String address;
    Date hireDate;
    float salary;
    String status;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "position_id",nullable = false)
    Position position;

    @ManyToOne
    @JoinColumn(name = "department_id",nullable = false)
    Department department;

}
