package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.User;

public interface FoodRepository extends JpaRepository<User, Long> {
}
