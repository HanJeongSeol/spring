package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		System.out.println("------ 스프링 컨테이너 구동전 ------");

		// 1. 스프링컨테이너 구동(스프링 설정파일 읽어서)
		// factory 역할을 한다
		GenericXmlApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); // 스프링
																											// 컨테이너를
																											// 구동시킬
																											// 수 있다.
		System.out.println("------ 스프링 컨테이너 구동후 ------");

		// 2. 스프링컨테이너 사용
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean"); 
		
		System.out.println(">> 객체요청 후 -----------");
		System.out.println("--- List 타입 ---");	
		System.out.println("bean : " + bean);
		List<String> addressList = bean.getAddressList();
		for(String address : addressList) {
			System.out.println("address : " + address);
		}
		
		
		
		System.out.println(">> 객체요청 후 -----------");
		System.out.println("--- Set 타입 ---");	
		System.out.println("bean : " + bean);
		Set<String> addressSet = bean.getAddressSet();
		for(String address : addressSet) {
			System.out.println("address : " + address);
		}
		
		
		System.out.println(">> 객체요청 후 -----------");
		System.out.println("--- Map<k,v> 타입 ---");	
		System.out.println("bean : " + bean);
		Map<String,String> addressMap = bean.getAddressMap();
//		for(String address : addressMap) {
//			System.out.println("address : " + address);
//		}
		System.out.println(addressMap);
		
		
		
		System.out.println(">> 객체요청 후 -----------");
		System.out.println("--- Properties 타입 ---");	
		System.out.println("bean : " + bean);
		Properties addressProp = bean.getAddressProp();
//		for(String address : addressMap) {
//			System.out.println("address : " + address);
//		}
		System.out.println(addressProp);
		
		
		// 3. 스프링컨테이너 종료(close 처리)
		System.out.println("------ 스프링 컨테이너 종료처리 ------");
		factory.close();
	}
}
