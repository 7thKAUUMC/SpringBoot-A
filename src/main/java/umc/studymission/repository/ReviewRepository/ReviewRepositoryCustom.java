package umc.studymission.repository.ReviewRepository;

import umc.studymission.domain.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByDynamicCriteria(Integer rating, Long storeId);
}
