package p20181114;

//다중 인터페이스가 가능 
public class Ex4_SmartTelevision implements Ex4_RemoteControl,Ex4_Searchable {
	int volume;
	
	@Override
	public void turnOn() {
		System.out.println("스마트TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("스마트TV를 끕니다.");
		
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

	@Override
	public void search(String url) {
		System.out.println(url+"를 검색합니다.");
		
	}

}
