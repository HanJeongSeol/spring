package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AroundAdvice {

	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println("[Around BEFORE] 비즈니스 로직 실행 전 처리");

//		pjp.proceed();
		// 만약 실행시킬 메소드에서 반환해야하는 값이 존재하는 경우 Object 객체에 정보를 저장하고 반환시킨다
		Object returnObj = pjp.proceed();

		// 후처리 하려면 pjp.proceed() 메소드 이후에 작성
		System.out.println("[Around AFTER] 비즈니스 로직 실행 후 처리");

		return returnObj;
	}
}
