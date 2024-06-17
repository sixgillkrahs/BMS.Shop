package com.main.backend.Utils.Exception;

public enum ErrorCode {
    USER_NOT_FOUND(401, "User not found"),
    EMAIL_ALREADY_EXISTS(402, "Email already exists"),
    ROLE_NOT_FOUND (401, "Role not found"),
    CATEGORY_NOT_FOUND(401, "Category not found"),
    MANUFACTURER_NOT_FOUND(401, "Manufacturer not found"),
    PRODUCT_NOT_FOUND(401, "Product not found"),
    WRONG_PASSWORD(401, "Wrong password"),
    EMAIL_NOT_FOUND(401, "Email not found"),
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
