package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.status.ErrorStatus;

public class RegionHandler extends RuntimeException {
    private final ErrorStatus errorStatus;

    public RegionHandler(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }
}
