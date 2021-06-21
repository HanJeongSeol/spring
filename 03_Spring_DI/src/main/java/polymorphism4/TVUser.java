package polymorphism4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		System.out.println("------ 스프링 컨테이너 구동전 ------");
		
		//1. 스프링컨테이너 구동(스프링 설정파일 읽어서)
		// factory 역할을 한다
		GenericXmlApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext_4.xml"); // 스프링 컨테이너를 구동시킬 수 있다.
		System.out.println("------ 스프링 컨테이너 구동후 ------");

		//2. 스프링컨테이너 사용
		System.out.println("--- tv 요청 사용 ---");
		TV tv = (TV)factory.getBean("tv4");  // tv라는 이름의 객체가 있다면 불러와서 사용한다.
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
		System.out.println("tv 객체 확인 : " + tv);

		
		//3. 스프링컨테이너 종료(close 처리)
		System.out.println("------ 스프링 컨테이너 종료처리 ------");
		factory.close();
	}
}
