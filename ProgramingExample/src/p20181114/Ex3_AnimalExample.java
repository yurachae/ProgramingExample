package p20181114;
//실체 클래스
public  class Ex3_AnimalExample {
	public static void main(String[] args) {
		Ex3_Cat cat = new Ex3_Cat("고양이");
		Ex3_Dog dog = new Ex3_Dog("강아지");
		
		cat.breathe();
		cat.sound();
		
		System.out.println();
		
		dog.breathe();
		dog.sound();
		
	}
	
}
