package umc.study.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.repository.RestaurantRepository;
import umc.study.repository.ReviewRepository;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;
import umc.study.apiPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    public ReviewResponse addReview(Long restaurantId, ReviewRequest request) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND));

        Review review = ReviewConverter.toReview(restaurant, request);
        review = reviewRepository.save(review);

        return ReviewConverter.toReviewResponse(review);
    }
}
