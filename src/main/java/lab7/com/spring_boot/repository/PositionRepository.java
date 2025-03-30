package lab7.com.spring_boot.repository;

import lab7.com.spring_boot.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
