package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RestaurantResponse {
    private Long restaurantId;
    private Long regionId;
    private String restaurantName;
    private String address;
    private String phoneNumber;
    private String category;
}
