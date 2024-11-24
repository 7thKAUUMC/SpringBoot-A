package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.ExistRestaurantValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistRestaurantValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistRestaurant {
    String message() default "Restaurant does not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}