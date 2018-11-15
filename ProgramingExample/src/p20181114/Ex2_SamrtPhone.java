package p20181114;
//추상클래스의 자식클래스(실체클래스)

public class Ex2_SamrtPhone extends Ex2_Phone{
	//생성자
	public Ex2_SamrtPhone(String owner) {
		super(owner);
	}
	
	//메소드
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}

	//부모클래스인 추상클래스에 추상메소드가 있으니 추상메소드를 정의해야 함.
	@Override
	public void HangUp() {
		System.out.println("전화걸기");
	
	}
	
	
}
