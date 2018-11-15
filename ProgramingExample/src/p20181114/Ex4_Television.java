package p20181114;
//인터페이스 구현 클래스
public class Ex4_Television  implements Ex4_RemoteControl{
	//필드
	private int volume;
	
	//추상메소드의 실체 메소드
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
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
		System.out.println("현재 TV 볼륨 "+ this.volume);
	}
}
