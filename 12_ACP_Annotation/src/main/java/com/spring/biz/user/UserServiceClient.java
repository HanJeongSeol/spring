package com.spring.biz.user;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.user.impl.UserServiceImpl;

public class UserServiceClient {
	public static void main(String[] args) {
		System.out.println("------ 스프링 컨테이너 구동전 ------");
		
		//1. 스프링컨테이너 구동(스프링 설정파일 읽어서)
		// factory 역할을 한다
		GenericXmlApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml"); 
		System.out.println("------ 스프링 컨테이너 구동후 ------");

		//2. 스프링컨테이너 사용
		UserServiceImpl userService = (UserServiceImpl) container.getBean("userService");
		
		
		// 2-1. 유저 한명 검색
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		UserVO voOne = userService.getUser(vo);
		System.out.println(voOne);
		
		// 2-2. 전체 유저 검색
		List<UserVO> userList = userService.getUserList();
		for(UserVO list : userList) {
			System.out.println(list);
		}
		
		// 2-3. 유저 추가
		int insertResult = userService.insertUser();
		if(insertResult == 1) {
			System.out.println(">> 유저 추가 완료");
		}else {
			System.out.println(">> 유저 추가 실패");
		}
		
		// 2-3. 유저 삭제
		int deleteResult = userService.deleteUser();
		if(deleteResult == 1) {
			System.out.println(">> 유저 삭제 완료");
		} else {
			System.out.println(">> 유저 삭제 실패");
		}
		
		
		//3. 스프링컨테이너 종료(close 처리)
		System.out.println("------ 스프링 컨테이너 종료처리 ------");
		container.close();

	}
}
