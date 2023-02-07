package com.example.coupon.service.coupon;

import com.example.coupon.web.dto.coupon.CouponDto;
import com.example.coupon.web.dto.coupon.CouponEnrollDto;

import java.util.List;

public interface CouponService {
    CouponDto save(CouponEnrollDto couponEnrollDto);

    List<CouponDto> readAll();

    List<CouponDto> filteringReadAll();
}
