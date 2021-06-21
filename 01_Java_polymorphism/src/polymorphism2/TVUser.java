package polymorphism2;

public class TVUser {

	public static void main(String[] args) {
		// 삼성TV 사용
//		SamsungTV tv = new SamsungTV();
		TV tv = new SamsungTV();
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
		
		// LgTV 사용
		TV tv1 = new LgTV();
		tv1.powerOn();
		tv1.volumnUp();
		tv1.volumnDown();
		tv1.powerOff();
	}

}
