package lab7.com.spring_boot.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Date dateOfBirth;

    String phoneNumber;

    String address;

    @Temporal(TemporalType.DATE)
    Date hireDate;

    Float salary;

    String status;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    Department department;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    Position position;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}
