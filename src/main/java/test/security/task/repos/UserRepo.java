package test.security.task.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import test.security.task.entities.UserEntity;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    public Optional<UserEntity> findByEmail(String email);
}
