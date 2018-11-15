package p20181114;
//구현 클래스인 SmartPhone의 기능을 출력하는 메인 클래스
public class Ex5_Main {
	public static void main(String[] args) {
		Ex5_SmartPhone smartphone = new Ex5_SmartPhone();
		
		smartphone.buttonSetting();
		smartphone.HangIn();
		smartphone.HangOut();
		smartphone.playMusic();
		smartphone.stopMusic();
		smartphone.sendMessage();
		smartphone.receiveMessage();
		System.out.println(smartphone.sum(10, 10));
	}

}
