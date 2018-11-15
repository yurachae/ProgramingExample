package p20181114;
//PDA를 상속받고
//MobilePhone, MP3를 구현하는 클래스
public class Ex5_SmartPhone extends Ex5_PDA implements Ex5_MobilePhone,Ex5_MP3 {

	@Override
	public void HangIn() {
		System.out.println("스마트폰 전화 받기");
		
	}

	@Override
	public void HangOut() {
		System.out.println("스마트폰 전화 받기");
		
	}

	@Override
	public void playMusic() {
		System.out.println("음악 재생");
		
	}

	@Override
	public void stopMusic() {
		System.out.println("음악 정지");
		
	}

	@Override
	public void sendMessage() {
		System.out.println("메세지 보내기");		
	}

	@Override
	public void receiveMessage() {
		System.out.println("메세지 받기");
		
	}

}
