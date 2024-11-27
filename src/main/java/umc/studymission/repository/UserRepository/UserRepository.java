package umc.studymission.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.studymission.domain.User;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    // 사용자 이름 중복 체크
    boolean existsByUsername(String username);

    // 이메일 중복 체크
    boolean existsByEmail(String email);
}
