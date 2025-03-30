package lab7.com.spring_boot.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RolePermissionRequest {
    Long roleId;
    Long permissionId;
}
