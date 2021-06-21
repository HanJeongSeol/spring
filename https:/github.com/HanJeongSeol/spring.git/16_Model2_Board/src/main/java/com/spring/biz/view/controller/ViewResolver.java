package com.spring.biz.view.controller;

/*
 * ViewResolver 클래스는 Controller가 리턴한 String(뷰이름)
 * 접두어(prefix)와 접미어(sufix)를 결합해서
 * 재요청(응답할)페이지의 경로와 파일명을 완성해서 리턴
 * DispatcherSevlet의 init() 호출시 생성
 * */
public class ViewResolver {
	private String prefix; // ./ (현재위치)
	private String sufix; // .jsp(확장명 붙이기)

	public void setPrefix(String prefix) {
		this.prefix = prefix;	
	}

	public void setSufix(String sufix) {
		this.sufix = sufix;
	}

	// 문자를 전달받으면 전달받은 문자에 prefix, sufix를 이어붙인다.
	public String getView(String viewName) {
		return prefix + viewName + sufix;
	}
}
