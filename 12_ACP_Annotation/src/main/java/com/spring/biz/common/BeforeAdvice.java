package com.spring.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service // 객체(인스턴스) 생성
@Aspect // 포인트컷 + 어드바이스 연결
public class BeforeAdvice {
	
	// xml에 작성했던 pointcut 태그를 메소드로 구현한다. 
	// 메소드 이름이 xml에서 설정했던 id값이 된다.
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	// 어드바이스의 동작시점 설정 + 포인트컷 지정, xml에서 아래 주석 설정 역할을 수행한다. 
	/* 
		<aop:aspect ref="before">
			<aop:before method="beforeLog" pointcut-ref="allPointcut"/>
		</aop:aspect>
	*/
	@Before("allPointcut()")
	public void beforeLog() { // 어드바이스 메소드를 설정 
		System.out.println("[사전처리 - BeforeAdvice.beforeLog]"
				+ "비즈니스 로직 수행 전 로그");
	}
}
