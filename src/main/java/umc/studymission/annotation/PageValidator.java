package umc.studymission.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null || page < 1) {
            return false; // 0 이하의 값은 유효하지 않음
        }
        return true;
    }
}
