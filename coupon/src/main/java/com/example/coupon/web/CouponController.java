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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor
@Slf4j
public class CouponController {

    private final CouponService couponService;

    @PostMapping("/enroll")
    public BaseResponseDto<CouponDto> enrollCoupon(@Valid @RequestBody CouponEnrollDto couponEnrollDto, BindingResult bindingResult) {
        checkValidation(bindingResult);
        CouponDto coupon = couponService.save(couponEnrollDto);
        return new BaseResponseDto<>(coupon);
    }

    @GetMapping()
    public BaseResponseDto<List<CouponDto>> readAllCoupon() {
        List<CouponDto> couponDtos = couponService.readAll();
        return new BaseResponseDto<>(couponDtos);
    }

    @GetMapping("/filter")
    public BaseResponseDto<List<CouponDto>> filteringReadAllCoupon() {
        List<CouponDto> couponDtos = couponService.filteringReadAll();
        return new BaseResponseDto<>(couponDtos);
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
