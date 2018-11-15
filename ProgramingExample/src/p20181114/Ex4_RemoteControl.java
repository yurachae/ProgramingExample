package p20181114;
//인터페이스 
public interface Ex4_RemoteControl {
	//상수필드
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	
	//디폴트 메소드 : 기본
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리");
		}else {
			System.out.println("무음 해제");
		}
	}
	
	
	//정적메소드 : 객체 생성 없이 바로 사용 가능.
	static void changeBattery() {
		System.out.println("건전지 교체");
	}
}
