package p20181113;

public class Ex1_DmbCellPhoneExample {
	public static void main(String[] args) {
		//객체 생성
		Ex1_DmbCellPhone phone = new Ex1_DmbCellPhone("갤럭시8", "골드", 18);
		
		//필드값 (자식클래스) 출력
		System.out.println(phone.model);
		System.out.println(phone.color);
		System.out.println(phone.channel);
		
		//부모클래스 메소드 호출
		phone.Print();
		//자식클래스 메소드 호출 
		phone.DmbPrint();
	}
}
