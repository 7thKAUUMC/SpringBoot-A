package umc.study.converter;

import umc.study.domain.Restaurant;
import umc.study.domain.Region;
import umc.study.web.dto.RestaurantRequest;
import umc.study.web.dto.RestaurantResponse;

public class RestaurantConverter {

    // RestaurantRequest DTO를 받아 Restaurant 엔티티를 생성합니다.
    public static Restaurant toEntity(RestaurantRequest request, Region region) {
        return Restaurant.builder()
                .restaurantName(request.getRestaurantName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .category(request.getCategory())
                .region(region)
                .build();
    }

    // Restaurant 엔티티를 받아 RestaurantResponse DTO를 생성합니다.
    public static RestaurantResponse toDto(Restaurant restaurant) {
        return new RestaurantResponse(
                restaurant.getId(),
                restaurant.getRegion().getId(),
                restaurant.getRestaurantName(),
                restaurant.getAddress(),
                restaurant.getPhoneNumber(),
                restaurant.getCategory()
        );
    }
}
