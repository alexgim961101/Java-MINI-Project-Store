package com.example.coupon.handler.ex;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BaseResponseStatus {
    // 1000 : 요청 성공
    SUCCESS(true, 1000, "요청에 성공하였습니다"),

    // 2000 : Request 오류
    INVALID_REQUEST(false, 2000, "잘못된 요청값입니다");

    // 3000 : Response 오류


    // 4000 : DB 오류


    // 5000 : 서버 오류
    private final boolean isSuccess;
    private final int code;
    private final String message;
}
