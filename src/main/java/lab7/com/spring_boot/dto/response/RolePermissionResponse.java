package lab7.com.spring_boot.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RolePermissionResponse {
    Long roleId;
    Long permissionId;
    String roleName;
    String permissionName;
}
