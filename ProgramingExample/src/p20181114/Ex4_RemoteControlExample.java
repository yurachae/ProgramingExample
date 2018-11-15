package p20181114;
//
public class Ex4_RemoteControlExample {
	public static void main(String[] args) {
		//인터페이스 타입 변수 선언.
		Ex4_RemoteControl rc;
		Ex4_Searchable s;
		
		
		//인터페이스 타입 변수에 구현 클래스 객체 대입
		rc = new Ex4_Television();
		
		//구현클래스 객체가 대입된 변수의 메소드를 호출.
		rc.turnOn();
		rc.setVolume(5);
		rc.setMute(true);
		rc.turnOff();
		//static 메소드라서 객체 생성 없이 가능.
		Ex4_RemoteControl.changeBattery();
		
		System.out.println();
		
		rc = new Ex4_Audio();	//다형성
		rc.turnOn();
		rc.setVolume(5);
		rc.setMute(true);
		rc.turnOff();
		Ex4_RemoteControl.changeBattery();

		System.out.println();
		
		rc = new Ex4_SmartTelevision();
		rc.turnOn();
		rc.setVolume(5);
		rc.setMute(false);
		((Ex4_SmartTelevision) rc).search("네이버");
		rc.turnOff();
		
	}
}
