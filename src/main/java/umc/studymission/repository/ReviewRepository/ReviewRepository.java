package umc.studymission.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.studymission.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
}
