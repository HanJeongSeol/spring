package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 객체 생성을 요청하는 어노테이션
@Component  // lgTV 명칭으로 객체를 생성한
public class LgTV implements TV {
	
	@Autowired
//	@Qualifier("apple")
	Speacker speacker;
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
		speacker.volumnUp();
	}

	@Override
	public void volumnDown() {
		System.out.println("LgTV - 볼륨Down");
		speacker.volumnDown();
	}

	// ---------------------------------------

	public void initMethod() {
		System.out.println("LgTV - initMethod() 실행");
	}

	public void destoryMethod() {
		System.out.println("LgTV - destoryMethod() 실행");
	}
}
