package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		// JoinPoint -> 실행시킬 메소드 정보를 전달한다 -> pjp로
		// pjp.proceed()를 수행해야 메소드가 시작된다.
		
		
		// 전처리 하려면 pjp.proceed() 메소드 전에 작성
		// 핵심 메소드 실행 전
		System.out.println("[Around BEFORE] 비즈니스 로직 실행 전 처리");
		
		
//		pjp.proceed();
		// 만약 실행시킬 메소드에서 반환해야하는 값이 존재하는 경우 Object 객체에 정보를 저장하고 반환시킨다
		Object returnObj = pjp.proceed();
		
		
		// 후처리 하려면 pjp.proceed() 메소드 이후에 작성
		System.out.println("[Around AFTER] 비즈니스 로직 실행 후 처리");
		
		return returnObj;
	}
}
