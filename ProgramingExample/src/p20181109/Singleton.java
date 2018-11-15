package p20181109;
//싱글톤 : 객체를 하나만 사용하도록. 여러개 만들지 못함.

public class Singleton {
	
	//자기 자신을 객체로. 접근 제한자. 
	private static Singleton singleton= new Singleton();
	
	//기본 생성자
	private Singleton() {		
	}
	
	//리턴타입이 싱글톤 클래스 타입인 메소드. 직접 접근 가능.
	static Singleton getInstance() {
		return singleton;	//간접적으로 singleton에 접근.
	}
}
