package com.main.backend.Utils.Exception;

import com.main.backend.Domain.APIRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@FieldDefaults(level = AccessLevel.PUBLIC)
public class GlobalHandleException {

    @ExceptionHandler(value = HandleRuntimeException.class)
    ResponseEntity<APIRepository> handleRuntimeException(HandleRuntimeException e){
        ErrorCode errorCode = e.getErrorCode();
        APIRepository response = new APIRepository();
        response.setCode(errorCode.getCode());
        response.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
