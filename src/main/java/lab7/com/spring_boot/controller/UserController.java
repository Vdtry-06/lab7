package lab7.com.spring_boot.controller;

import lab7.com.spring_boot.dto.ApiResponse;
import lab7.com.spring_boot.dto.request.UserRequest;
import lab7.com.spring_boot.dto.request.UserUpdateRequest;
import lab7.com.spring_boot.dto.response.UserResponse;
import lab7.com.spring_boot.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    UserService userService;

    @PostMapping
    public ApiResponse<UserResponse> addUser(@RequestBody UserRequest request) {
        return ApiResponse.<UserResponse>builder()
                .message("Success")
                .data(userService.addUser(request))
                .build();
    }

    @PutMapping("{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .message("Success")
                .data(userService.updateUser(id, request))
                .build();
    }

    @DeleteMapping("{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ApiResponse.<Void>builder()
                .build();
    }

    @GetMapping("{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable Long id) {
        return ApiResponse.<UserResponse>builder()
                .message("Success")
                .data(userService.getUserById(id))
                .build();
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUsers() {
        return ApiResponse.<List<UserResponse>>builder()
                .message("Success")
                .data(userService.getAllUsers())
                .build();
    }
}
