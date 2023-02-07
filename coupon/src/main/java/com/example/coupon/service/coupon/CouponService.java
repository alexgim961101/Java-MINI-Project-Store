package com.example.coupon.service.coupon;

import com.example.coupon.web.dto.coupon.CouponDto;
import com.example.coupon.web.dto.coupon.CouponEnrollDto;

public interface CouponService {
    CouponDto save(CouponEnrollDto couponEnrollDto);
}
