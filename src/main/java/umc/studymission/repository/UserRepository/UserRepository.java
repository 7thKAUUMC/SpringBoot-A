package umc.studymission.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.studymission.domain.User;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
