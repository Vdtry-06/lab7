package lab7.com.spring_boot.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "role_permissions")
@IdClass(RolePermission.RolePermissionId.class)
public class RolePermission {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    Role role;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id", nullable = false)
    Permission permission;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RolePermissionId implements Serializable {
        Long role;
        Long permission;
    }
}
