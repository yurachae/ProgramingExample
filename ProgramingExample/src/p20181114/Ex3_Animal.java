package p20181114;
//추상클래스
//동물의 종류를 담는 필드
//숨을 쉰다는 메소드
//소리를 낸다는 추상메소드
//
public abstract class Ex3_Animal {
	String kind;
	
	public Ex3_Animal(String kind) {
		this.kind = kind;
	}
	
	public void breathe() {
		System.out.println(kind+"가 숨을 쉽니다.");
	}
	
	public abstract void sound(); //추상 메소드
}
