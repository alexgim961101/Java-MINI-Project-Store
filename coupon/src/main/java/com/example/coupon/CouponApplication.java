package com.example.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
/**
 * 고민 1 : Entity를 Dto로 바꿔버린 것
 * 고민 2 : 쿠폰 사용 불가 처리를 어느 시점에 해야 할까? 매일 밤? 아니면 조회시?
 * 고민 3 : bindingResult 작동X => @validated 어노테이션과 같이 사용하면 Dto의 validation 오류들이 BindingResult로 안넘어감
 * */

@SpringBootApplication
public class CouponApplication {
	public static void main(String[] args) {
		SpringApplication.run(CouponApplication.class, args);
	}
}
