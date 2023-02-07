package com.example.coupon.web;

import com.example.coupon.handler.ex.BaseException;
import com.example.coupon.handler.ex.BaseResponseStatus;
import com.example.coupon.service.coupon.CouponService;
import com.example.coupon.web.dto.BaseResponseDto;
import com.example.coupon.web.dto.coupon.CouponDto;
import com.example.coupon.web.dto.coupon.CouponEnrollDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/controller")
@RequiredArgsConstructor
@Slf4j
public class CouponController {

    private final CouponService couponService;

    @PostMapping("/enroll")
    public BaseResponseDto<?> enrollCoupon(@Valid @RequestBody CouponEnrollDto couponEnrollDto, BindingResult bindingResult) {
        checkValidation(bindingResult);
        CouponDto coupon = couponService.save(couponEnrollDto);
        return new BaseResponseDto<>(coupon);
    }



    public void checkValidation(BindingResult bindingResult) {
        log.info("-------- Validation 발견 ----------");
        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new BaseException(BaseResponseStatus.INVALID_REQUEST, errorMap);
        }
    }
}
