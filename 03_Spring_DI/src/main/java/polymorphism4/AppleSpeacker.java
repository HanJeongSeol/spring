package polymorphism4;

public class AppleSpeacker implements Speacker{
	// 생성자 만들기
	public AppleSpeacker() {
		System.out.println("-->> AppleSpeacker 생성");
	}
	@Override
	public void volumnUp() {
		System.out.println("-->> AppleSpeacker 소리 크게");
	}
	@Override
	public void volumnDown() {
		System.out.println("-->> AppleSpeacker 소리 작게");
	}
}
