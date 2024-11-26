package umc.spring.ApiPayload.exception.handler;

import lombok.Getter;
import umc.spring.ApiPayload.code.status.ErrorStatus;

@Getter
public class StoreHandler extends RuntimeException {
    private final ErrorStatus errorstatus;

    public StoreHandler(ErrorStatus errorstatus) {
        super(errorstatus.getMessage());
        this.errorstatus = errorstatus;
    }
}