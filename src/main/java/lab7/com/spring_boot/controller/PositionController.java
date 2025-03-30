package lab7.com.spring_boot.controller;

import lab7.com.spring_boot.dto.ApiResponse;
import lab7.com.spring_boot.dto.request.PositionRequest;
import lab7.com.spring_boot.dto.response.PositionResponse;
import lab7.com.spring_boot.service.PositionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PositionController {
    PositionService PositionService;

    @PostMapping
    public ApiResponse<PositionResponse> addPosition(@RequestBody PositionRequest request) {
        return ApiResponse.<PositionResponse>builder()
                .message("added Position Successfully")
                .data(PositionService.addPosition(request))
                .build();
    }

    @PutMapping("{id}")
    public ApiResponse<PositionResponse> updatePosition(@PathVariable Long id, @RequestBody PositionRequest request) {
        return ApiResponse.<PositionResponse>builder()
                .message("update id Position Successfully")
                .data(PositionService.updatePosition(id, request))
                .build();
    }

    @DeleteMapping("{id}")
    public ApiResponse<Void> deletePosition(@PathVariable Long id) {
        PositionService.deletePosition(id);
        return ApiResponse.<Void>builder()
                .message("Deleted id Position successfully")
                .build();
    }

    @GetMapping
    public ApiResponse<List<PositionResponse>> getAllPositions() {
        return ApiResponse.<List<PositionResponse>>builder()
                .message("get all Positions Successfully")
                .data(PositionService.getAllPositions())
                .build();
    }

    @GetMapping("{id}")
    public ApiResponse<PositionResponse> getPositionById(@PathVariable Long id) {
        return ApiResponse.<PositionResponse>builder()
                .message("get id Position Successfully")
                .data(PositionService.getPositionById(id))
                .build();
    }
}
