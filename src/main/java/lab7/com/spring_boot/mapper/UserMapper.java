package lab7.com.spring_boot.mapper;

import lab7.com.spring_boot.dto.request.UserRequest;
import lab7.com.spring_boot.dto.response.UserResponse;
import lab7.com.spring_boot.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest request);

    UserResponse toUserResponse(User user);
}
