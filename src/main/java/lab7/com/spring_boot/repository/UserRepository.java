package lab7.com.spring_boot.repository;

import lab7.com.spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
