package com.main.backend.Utils.Exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HandleRuntimeException extends RuntimeException{
    public HandleRuntimeException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    private ErrorCode errorCode;
}
