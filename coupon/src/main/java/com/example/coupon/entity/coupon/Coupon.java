package com.example.coupon.entity.coupon;

import com.example.coupon.entity.BaseEntity;
import com.example.coupon.web.dto.coupon.CouponDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "coupon")
public class Coupon extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime beginDt;

    @Column(nullable = false)
    private LocalDateTime endDt;

    @Column(nullable = false)
    private CouponStatus status;

    // BaseEntity를 상속 받았기 때문에 아래와 같이 생성자를 만들어야 Builder 패턴 사용 가능
    @Builder
    public Coupon(Long id, String title, String content, LocalDateTime beginDt, LocalDateTime endDt, CouponStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.title = title;
        this.content = content;
        this.beginDt = beginDt;
        this.endDt = endDt;
        this.status = status;
    }


    // 영속 상태의 Entity를 그대로 쓰기에는 위험부담이 크다. (혹시 영속성 컨텍스트는 트렌잭션 단위???)
    // 그래서 Entity와 비슷한 Dto를 만들어서 반환하는게 더 좋을 듯???
    public CouponDto toDto(){
        return CouponDto.builder()
                .id(id)
                .title(title)
                .content(content)
                .beginDt(beginDt)
                .endDt(endDt)
                .status(status)
                .createdAt(super.getCreatedAt())
                .updatedAt(super.getUpdatedAt()).build();

    }
}
