package com.example.coupon.service.coupon;

import com.example.coupon.entity.coupon.Coupon;
import com.example.coupon.entity.coupon.CouponRepository;
import com.example.coupon.entity.coupon.CouponStatus;
import com.example.coupon.web.dto.coupon.CouponDto;
import com.example.coupon.web.dto.coupon.CouponEnrollDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService{

    private final CouponRepository couponRepository;
    @Override
    @Transactional
    public CouponDto save(CouponEnrollDto couponEnrollDto) {
        Coupon coupon = couponEnrollDto.toEntity();
        Coupon couponEntity = couponRepository.save(coupon);
        CouponDto couponDto = couponEntity.toDto();
        return couponDto;
    }

    @Override
    public List<CouponDto> readAll() {
        List<Coupon> couponEntityList = couponRepository.findAll();
        List<CouponDto> couponDtos = new ArrayList<>();

        for(Coupon coupon : couponEntityList) {
            checkAndSetDate(coupon);
            couponDtos.add(coupon.toDto());
        }
        return couponDtos;
    }

    @Override
    public List<CouponDto> filteringReadAll() {
        List<Coupon> couponEntityList = couponRepository.findAll();
        List<CouponDto> couponDtos = new ArrayList<>();

        Stream<Coupon> stream = couponEntityList.stream();
        stream.filter(cup -> Pattern.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*", cup.getTitle()))
                .forEach(cup -> couponDtos.add(cup.toDto()));

        return couponDtos;
    }

    @Transactional
    public void checkAndSetDate(Coupon coupon) {
        log.info(LocalDateTime.now().toString());
        if(coupon.getEndDt().isBefore(LocalDateTime.now())) coupon.setStatus(CouponStatus.UNABLE);
    }

}
