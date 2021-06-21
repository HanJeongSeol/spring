package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {
	
	// xml에 작성했던 pointcut 태그를 메소드로 구현한다. 
	// 메소드 이름이 xml에서 설정했던 id값이 된다.

	@AfterReturning(pointcut = "PointcutCommon.getPointcut()()", returning = "returnObj")
	public void afterReturningLog(JoinPoint jp, Object returnObj) {
		System.out.println("[후처리 - AfterReturningAdvice.afterReturningLog]"
				+ "비즈니스 로직 수행 후 로그(정상실행시)" + returnObj);
	}
}
