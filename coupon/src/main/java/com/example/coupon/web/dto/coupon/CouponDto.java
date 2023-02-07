package com.example.coupon.web.dto.coupon;

import com.example.coupon.entity.coupon.Coupon;
import com.example.coupon.entity.coupon.CouponStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime beginDt;
    private LocalDateTime endDt;
    private CouponStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Coupon toEntity() {
        return Coupon.builder()
                .id(id)
                .title(title)
                .content(content)
                .beginDt(beginDt)
                .endDt(endDt)
                .status(status).build();
    }
}
