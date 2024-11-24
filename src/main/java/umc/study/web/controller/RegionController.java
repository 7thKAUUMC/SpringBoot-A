package umc.study.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.RestaurantService;
import umc.study.web.dto.RestaurantRequest;
import umc.study.web.dto.RestaurantResponse;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    private final RestaurantService restaurantService;

    public RegionController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/{regionId}/restaurants")
    public ResponseEntity<ApiResponse<RestaurantResponse>> addRestaurant(
            @PathVariable Long regionId,
            @Valid @RequestBody RestaurantRequest restaurantRequest) {

        RestaurantResponse response = restaurantService.addRestaurant(regionId, restaurantRequest);
        return ResponseEntity.ok(ApiResponse.onSuccess(response));
    }
}
