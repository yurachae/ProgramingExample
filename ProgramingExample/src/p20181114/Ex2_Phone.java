package p20181114;
//추상클래스

public abstract class Ex2_Phone {
	// 필드선언
	public String owner;

	// 생성자 선언
	public Ex2_Phone(String owner) {
		this.owner = owner;
	}

	// 메소드 선언
	public void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}

	public void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}

	// 추상메소드 선언하기
	//메소드의 타입, 이름(매개변수) ;
	//이름만 정의함. 실행블록을 정하지 않음.
	public 	abstract void HangUp();	
	

}
