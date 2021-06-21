package di_annotation;

import org.springframework.stereotype.Component;

public class SonySpeacker implements Speacker {
	
	// 생성자 만들기
	public SonySpeacker() {
		System.out.println("-->> SonySpeacker 생성");
	}
	
	@Override
	public void volumnUp() {
		System.out.println("-->> SonySpeacker 소리 크게");
	}
	@Override
	public void volumnDown() {
		System.out.println("-->> SonySpeacker 소리 작게");
	}
}
