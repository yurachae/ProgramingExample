package p20181114;
//인터페이스 구현 클래스

public class Ex4_Audio implements Ex4_RemoteControl {
	//필드
	private int volume;
	private boolean mute;
	
	//추상메소드의 실체 메소드
	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("오디로를 끕니다.");
	}
	@Override
	public void setVolume(int volume) {
		if(volume>Ex4_RemoteControl.MAX_VOLUME) {
			this.volume = Ex4_RemoteControl.MAX_VOLUME;
		}else if (volume<Ex4_RemoteControl.MIN_VOLUME) {
			this.volume = Ex4_RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 오디오 볼륨 "+ this.volume);
	}
	
	//디폴트메소드 재정의 가능.
	@Override
	public void setMute(boolean mute) {
		this.mute = mute;
		if(mute) {
			System.out.println("오디오 무음 처리");
		}else {
			System.out.println("오디오 무음 해제");
		}
	}
}
