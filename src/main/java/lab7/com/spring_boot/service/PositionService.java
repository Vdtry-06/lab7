package lab7.com.spring_boot.service;


import lab7.com.spring_boot.dto.request.PositionRequest;
import lab7.com.spring_boot.dto.response.PositionResponse;
import lab7.com.spring_boot.entity.Position;
import lab7.com.spring_boot.mapper.PositionMapper;
import lab7.com.spring_boot.repository.PositionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PositionService {
    PositionRepository positionRepository;
    PositionMapper positionMapper;

    public PositionResponse addPosition(PositionRequest request) {
        Position position = positionMapper.toPosition(request);
        positionRepository.save(position);
        return positionMapper.toPositionResponse(position);
    }

    public PositionResponse updatePosition(Long id, PositionRequest request) {
        Position position = positionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Position not found"));
        if (request.getName() != null && !request.getName().equals(position.getName())) {
            position.setName(request.getName());
        }
        positionRepository.save(position);
        return positionMapper.toPositionResponse(position);
    }

    public void deletePosition(Long id) {
        Position position = positionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Position not found"));
        positionRepository.delete(position);
    }

    public List<PositionResponse> getAllPositions() {
        List<Position> positions = positionRepository.findAll();
        return positions.stream().map(positionMapper::toPositionResponse).toList();
    }

    public PositionResponse getPositionById(Long id) {
        Position position = positionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Position not found"));
        return positionMapper.toPositionResponse(position);
    }
}
