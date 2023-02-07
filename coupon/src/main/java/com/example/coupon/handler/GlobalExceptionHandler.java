package com.example.coupon.handler;

import com.example.coupon.handler.ex.BaseException;
import com.example.coupon.web.dto.BaseResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public BaseResponseDto allExceptionHandler(BaseException e) {
        return new BaseResponseDto(e.getStatus(), e.getErrorMap());
    }
}
