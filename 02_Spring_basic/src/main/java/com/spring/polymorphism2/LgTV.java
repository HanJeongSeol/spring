package com.spring.polymorphism2;

public class LgTV implements TV {

	public LgTV() {
		System.out.println(">> LgTV 객체 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원ON");

	}

	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원Off");

	}

	@Override
	public void volumnUp() {
		System.out.println("LgTV - 볼륨Up");

	}

	@Override
	public void volumnDown() {
		System.out.println("LgTV - 볼륨Down");

	}
	
	//---------------------------------------
	
	public void initMethod() {
		System.out.println("LgTV - initMethod() 실행");
	}
	public void destoryMethod() {
		System.out.println("LgTV - destoryMethod() 실행");
	}
}
