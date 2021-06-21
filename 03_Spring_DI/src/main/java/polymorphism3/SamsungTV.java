package polymorphism3;

class SamsungTV implements TV {
	private SonySpeacker speacker;
	private int price;
	private int width;
	private int height;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 객체 생성");
	}

	public SamsungTV(SonySpeacker speacker) {
		System.out.println(">> SamsungTV 객체 생");
		this.speacker = speacker;
	}

	
	public SamsungTV(SonySpeacker speacker, int price) {
		System.out.println(">> SamsungTV 객체 생");
		this.speacker = speacker;
		this.price = price;
	}
	
	public SamsungTV(SonySpeacker speacker, int width, int height) {
		System.out.println(">> SamsungTV 객체 생");
		this.speacker = speacker;
		this.width = width;
		this.height = height;
	}
	
	
	public void powerOn() {
		System.out.println("SamsungTV - 전원ON");

	}

	public void powerOff() {
		System.out.println("SamsungTV - 전원OFF");
	}

	public void volumnUp() {
		System.out.println("SamsungTV - 소리UP");
		speacker.volumnUp();
	}

	public void volumnDown() {
		System.out.println("SamsungTV - 소리DOWN");
		speacker.volumnDown();
	}

	// ------------------------------------
	public void initMethod() {
		System.out.println("SamsungTV - initMethod() 실행");
	}

	public void destoryMethod() {
		System.out.println("SamsungTV - destoryMethod() 실행");
	}

	public SonySpeacker getSpeacker() {
		return speacker;
	}

	public void setSpeacker(SonySpeacker speacker) {
		this.speacker = speacker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "SamsungTV [speacker=" + speacker + ", price=" + price + ", width=" + width + ", height=" + height + "]";
	}


	
	

}
