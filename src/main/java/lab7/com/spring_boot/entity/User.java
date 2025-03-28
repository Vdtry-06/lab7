package lab7.com.spring_boot.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    long userId;
    String username;
    String password;
    String email;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    Role role;

    @OneToOne(mappedBy = "user")
    Employee employee;

}
