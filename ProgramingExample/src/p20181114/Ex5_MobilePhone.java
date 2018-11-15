package p20181114;
//자식 인터페이스
//Phone 인터페이스를 상속 받음.
//문자를 보내고 받을 수 있음.
public interface Ex5_MobilePhone extends Ex5_Phone{
	
	//추상메소드
	public void sendMessage();		//메세지 보내기
	public void receiveMessage();	//메세지 받기
}
