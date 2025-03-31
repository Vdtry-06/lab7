package lab7.com.spring_boot.repository;

import lab7.com.spring_boot.entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, Long> {
}
