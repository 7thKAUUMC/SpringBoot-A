package umc.studymission.service.ReviewService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.studymission.domain.Review;

public interface ReviewQueryService {
    Page<Review> findByUserId(Long userId, Pageable pageable);
}