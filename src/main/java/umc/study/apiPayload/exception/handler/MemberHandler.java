package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.status.ErrorStatus;

public class MemberHandler extends RuntimeException {
    private final ErrorStatus errorStatus;

    public MemberHandler(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }
}
