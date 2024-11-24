package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.ValidMissionChallengeValidator;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidMissionChallengeValidator.class)
@Documented
public @interface ValidMissionChallenge {
    String message() default "MISSION_NOT_VALID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}