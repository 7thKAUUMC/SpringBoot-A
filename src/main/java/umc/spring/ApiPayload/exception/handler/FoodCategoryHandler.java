package umc.spring.ApiPayload.exception.handler;

import umc.spring.ApiPayload.code.status.ErrorStatus;

public class FoodCategoryHandler extends RuntimeException {
    private final ErrorStatus errorStatus;

    public FoodCategoryHandler(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }
}