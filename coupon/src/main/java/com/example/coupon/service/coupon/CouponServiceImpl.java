package com.example.coupon.service.coupon;

import com.example.coupon.entity.coupon.Coupon;
import com.example.coupon.entity.coupon.CouponRepository;
import com.example.coupon.web.dto.coupon.CouponDto;
import com.example.coupon.web.dto.coupon.CouponEnrollDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService{

    private final CouponRepository couponRepository;
    @Override
    public CouponDto save(CouponEnrollDto couponEnrollDto) {
        Coupon coupon = couponEnrollDto.toEntity();
        Coupon couponEntity = couponRepository.save(coupon);
        CouponDto couponDto = couponEntity.toDto();
        return couponDto;
    }
}
