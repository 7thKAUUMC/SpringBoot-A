package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.converter.RestaurantConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Region;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.repository.RegionRepository;
import umc.study.repository.RestaurantRepository;
import umc.study.repository.ReviewRepository;
import umc.study.web.dto.RestaurantRequest;
import umc.study.web.dto.RestaurantResponse;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantService {

    private final RegionRepository regionRepository;
    private final RestaurantRepository restaurantRepository;

    public RestaurantResponse addRestaurant(Long regionId, RestaurantRequest request) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));

        Restaurant restaurant = RestaurantConverter.toRestaurant(region, request);
        restaurant = restaurantRepository.save(restaurant);

        return RestaurantConverter.toRestaurantResponse(restaurant);
    }

    public RestaurantResponse getRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND));

        return RestaurantConverter.toRestaurantResponse(restaurant);
    }

    @Transactional
    public ReviewResponse addReview(Long restaurantId, ReviewRequest reviewRequest) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND));

        Review review = ReviewConverter.toReview(restaurant, reviewRequest);
        review = ReviewRepository.save(review);

        return ReviewConverter.toReviewResponse(review);
    }
}