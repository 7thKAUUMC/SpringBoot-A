package umc.study.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.RestaurantService;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.web.dto.RestaurantRequest;
import umc.study.web.dto.RestaurantResponse;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;


@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // GET 매핑 추가
    @GetMapping("/{restaurantId}")
    public ResponseEntity<ApiResponse<RestaurantResponse>> getRestaurant(
            @PathVariable Long restaurantId) {
        RestaurantResponse response = restaurantService.getRestaurant(restaurantId);
        return ResponseEntity.ok(ApiResponse.onSuccess(response));
    }

    @PostMapping("/{restaurantId}/reviews")
    public ResponseEntity<ApiResponse<ReviewResponse>> addReview(
            @PathVariable Long restaurantId,
            @Valid @RequestBody ReviewRequest reviewRequest) {
        ReviewResponse response = restaurantService.addReview(restaurantId, reviewRequest);
        return ResponseEntity.ok(ApiResponse.onSuccess(response));
    }
}