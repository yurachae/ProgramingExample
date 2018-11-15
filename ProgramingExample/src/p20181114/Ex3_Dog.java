package p20181114;
//실체 클래스
public  class Ex3_Dog extends Ex3_Animal {
	public Ex3_Dog(String kind) {
		super(kind);
	}
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	
}
