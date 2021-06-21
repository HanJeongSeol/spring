package com.spring.polymorphism2;

class SamsungTV implements TV{
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 객체 생성");
	}
	public void powerOn() {
		System.out.println("SamsungTV - 전원ON");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV - 전원OFF");
	}
	
	public void volumnUp() {
		System.out.println("SamsungTV - 소리UP");
	}
	
	public void volumnDown() {
		System.out.println("SamsungTV - 소리DOWN");
	}
	
	// ------------------------------------
	public void initMethod() {
		System.out.println("SamsungTV - initMethod() 실행");
	}
	public void destoryMethod() {
		System.out.println("SamsungTV - destoryMethod() 실행");
	}
	
}
