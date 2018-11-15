package p20181114;

public class Ex1_InstanceOfParent {
	//Ex1_Parent 클래스 타입의 변수 parent를 매개변수로 받는 메소드.
	//강제 형 변환이 가능한지 확인하는 메소드
	public static void method1(Ex1_Parent parent) {
		if(parent instanceof Ex1_Child) {
			//Child 타입으로 변환이 가능한지 확인
			//parent가 Ex1_Child 클래스 타입이라면 
			//강제 형 변환 가능.
			Ex1_Child child = (Ex1_Child)parent;
			//Ex1_Child 타입의 변수 child에 Ex1_Child 타입으로 강제 형변환을 한 parent를 대입.
			System.out.println("method1- Child로 변환 성공");
		}else {
			System.out.println("method1- Child로 변환 실패");
		}
	}
	
	public static void method2(Ex1_Parent parent) {
		Ex1_Child child = (Ex1_Child) parent;	
		//ClassCastException 발생 가능성 있음.
		//그냥 강제 형 변환을 하는 것.
		System.out.println("method2 - Child로 변환 성공");
	}
	
	public static void main(String[] args) {
		//Ex1_Parent 클래스 타입의 변수 parentA에 Ex1_Child() 객체 대입.
		Ex1_Parent parentA = new Ex1_Child();
		method1(parentA);
		method2(parentA);
		System.out.println();

		//Ex1_Parent 클래스 타입의 변수 parentA에 Ex1_Parent() 객체 대입.
		Ex1_Parent parentB = new Ex1_Parent();
		method1(parentB);
		method2(parentB);
	}
}
