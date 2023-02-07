package com.example.coupon.handler.ex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseException extends RuntimeException{
    private BaseResponseStatus status;
    private Map<String, String> errorMap;

    public BaseException(BaseResponseStatus status) {
        this.status = status;
    }
}
