package lab7.com.spring_boot.mapper;

import lab7.com.spring_boot.dto.request.PositionRequest;
import lab7.com.spring_boot.dto.response.PositionResponse;
import lab7.com.spring_boot.entity.Position;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionMapper {
    Position toPosition(PositionRequest request);

    PositionResponse toPositionResponse(Position position);
}
