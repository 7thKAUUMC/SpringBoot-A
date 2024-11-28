package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Restaurant;
import umc.study.domain.Region;
import umc.study.web.dto.RestaurantRequest;
import umc.study.web.dto.RestaurantResponse;

@Component
public class RestaurantConverter {

    public static Restaurant toRestaurant(Region region, RestaurantRequest request) {
        return Restaurant.builder()
                .region(region)
                .restaurantName(request.getRestaurantName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .category(request.getCategory())
                .build();
    }

    public static RestaurantResponse toRestaurantResponse(Restaurant restaurant) {
        return RestaurantResponse.builder()
                .restaurantId(restaurant.getId())
                .regionId(restaurant.getRegion().getId())
                .restaurantName(restaurant.getRestaurantName())
                .address(restaurant.getAddress())
                .phoneNumber(restaurant.getPhoneNumber())
                .category(restaurant.getCategory())
                .build();
    }
}
