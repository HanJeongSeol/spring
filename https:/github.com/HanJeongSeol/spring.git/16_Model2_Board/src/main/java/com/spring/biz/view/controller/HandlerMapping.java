package com.spring.biz.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.spring.biz.view.user.LoginController;

/*
 * HandlerMapping 요청정보와 처리할 컨트롤러를 연결하는 정보 저장 
 * 어떤 정보가 들어오면 누가 처리할지 정해주는 역할을 한다 
 * DispatcherServlet의 init() 호출 시 생성된다.
 * 
 * */

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
