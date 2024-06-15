package com.main.backend.Utils.Exception;

public enum ErrorCode {
    USER_NOT_FOUND(401, "User not found"),
    USERNAME_ALREADY_EXISTS(402, "Username already exists"),
    ROLE_NOT_FOUND (403, "Role not found"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
