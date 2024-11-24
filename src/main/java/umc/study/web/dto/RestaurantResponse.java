package umc.study.web.dto;

public class RestaurantResponse {
    private Long restaurantId;
    private Long regionId;
    private String restaurantName;
    private String address;
    private String phoneNumber;
    private String category;

    // Constructor
    public RestaurantResponse(Long restaurantId, Long regionId, String restaurantName, String address, String phoneNumber, String category) {
        this.restaurantId = restaurantId;
        this.regionId = regionId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.category = category;
    }

    // Getters
    public Long getRestaurantId() {
        return restaurantId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCategory() {
        return category;
    }
}
