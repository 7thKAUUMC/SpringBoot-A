package umc.study.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
public class RestaurantService {

    private final RegionRepository regionRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository; // 리뷰 저장을 위한 리포지토리

    public RestaurantService(RegionRepository regionRepository, RestaurantRepository restaurantRepository, ReviewRepository reviewRepository) {
        this.regionRepository = regionRepository;
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }

    @Transactional
    public RestaurantResponse addRestaurant(Long regionId, RestaurantRequest request) {
        // 지역 존재 여부 확인
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new IllegalArgumentException("Region not found"));

        // 레스토랑 저장
        Restaurant restaurant = Restaurant.builder()
                .restaurantName(request.getRestaurantName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .category(request.getCategory())
                .region(region)
                .build();

        restaurant = restaurantRepository.save(restaurant);

        // Response 생성
        return new RestaurantResponse(
                restaurant.getId(),
                region.getId(),
                restaurant.getRestaurantName(),
                restaurant.getAddress(),
                restaurant.getPhoneNumber(),
                restaurant.getCategory()
        );
    }

    @Transactional
    public ReviewResponse addReview(Long restaurantId, ReviewRequest request) {
        // 레스토랑 존재 여부 확인
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        // 리뷰 생성 및 저장
        Review review = Review.builder()
                .restaurant(restaurant)
                .rating(request.getRating())
                .Comment(request.getComment())
                .build();

        review = reviewRepository.save(review);

        // Response 생성
        return new ReviewResponse(
                review.getId(),
                review.getRating(),
                review.getComment()
        );
    }
}
