package umc.study.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.RestaurantService;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    // 의존성 주입을 위한 생성자
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/{restaurantId}/reviews")
    public ResponseEntity<ApiResponse<ReviewResponse>> addReview(
            @PathVariable Long restaurantId,
            @Valid @RequestBody ReviewRequest reviewRequest) {

        ReviewResponse response = restaurantService.addReview(restaurantId, reviewRequest);
        return ResponseEntity.ok(new ApiResponse<>(true, "SUCCESS", "Review added successfully", response));
    }
}
