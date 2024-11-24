
// ExistRestaurantValidator.java
package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import umc.study.repository.RestaurantRepository;
import umc.study.validation.annotation.ExistRestaurant;

public class ExistRestaurantValidator implements ConstraintValidator<ExistRestaurant, Long> {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public boolean isValid(Long restaurantId, ConstraintValidatorContext context) {
        return restaurantId != null && restaurantRepository.existsById(restaurantId);
    }
}
