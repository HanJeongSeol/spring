package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

import com.spring.biz.user.UserVO;

public class AfterReturningAdvice {
//	public void afterReturningLog() {
//		System.out.println("[후처리 - AfterReturningAdvice.afterReturningLog]"
//				+ "비즈니스 로직 수행 후 로그(정상실행시)");
//	}
//	
	
	//returnObj : 추가 바인드변수 사용시에는 스프링에 설정파일에 알려줘야한다.
	public void afterReturningLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		
		// 리턴받은 객체를 확인하고 필요한 작업 처리
		// 분기처리 가능, 반환받은 값을 가지고 일반회원, 관리자 분류 가능 
		if(returnObj instanceof UserVO) {
			UserVO vo = (UserVO)returnObj;
			if("admin".equalsIgnoreCase(vo.getRole())) {
				System.out.println(vo.getName() + "로그인(Admin)");
			}
		}
		System.out.println("[후처리]" + methodName +"() 메소드" +", 리턴값 : " + returnObj );
	}
	
}
