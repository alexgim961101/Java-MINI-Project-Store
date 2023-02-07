package com.example.coupon.web.dto.coupon;

import com.example.coupon.annotation.Day;
import com.example.coupon.entity.coupon.Coupon;
import com.example.coupon.entity.coupon.CouponStatus;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CouponEnrollDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    @Day
    private String beginDt;

    @Day
    private String endDt;

    @AssertTrue(message = "쿠폰 시작일과 만료일의 관계가 잘못되었습니다")
    public boolean isBeginDtAndEndDtValidation(){
        LocalDateTime start = LocalDateTime.parse(beginDt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime end = LocalDateTime.parse(endDt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return start.isBefore(end);
    }

    public Coupon toEntity() {
        LocalDateTime start = LocalDateTime.parse(beginDt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime end = LocalDateTime.parse(endDt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return Coupon.builder()
                .title(title)
                .content(content)
                .beginDt(start)
                .endDt(end)
                .status(CouponStatus.ENABLE).build();
    }
}
