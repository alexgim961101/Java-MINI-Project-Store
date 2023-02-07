package com.example.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
/**
 * 고민 1 : Entity를 Dto로 바꿔버린 것 -> 개인적인 생각으로는 영속상태 엔티티는 더티체크에 의해 값 변질 위험 있음
 * -> 엔티티에 toDto 메서드로 변환하여 return하면 안전하지 않을까 생각해봄
 * 고민 2 : 쿠폰 사용 가능 검증 처리를 어느 시점에 해야 할까? 매일 밤? 아니면 조회시?
 * 고민 2-1 : 쿠폰 조회 시 쿠폰 사용 검증을 할 경우 readAll API를 PUT Method로 해야할까? GET Method로 해야할까?
 * ==> 일단 조회 시 검증 처리를 진행하였고, GET Method를 사용하는 중
 * 고민 3 : bindingResult 작동X => @validated 어노테이션과 같이 사용하면 Dto의 validation 오류들이 BindingResult로 안넘어감
 * */

@SpringBootApplication
public class CouponApplication {
	public static void main(String[] args) {
		SpringApplication.run(CouponApplication.class, args);
	}
}
