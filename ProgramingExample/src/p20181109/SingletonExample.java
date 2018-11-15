package p20181109;

public class SingletonExample {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance(); 
		//new 연산자 없이 바로 접근 가능.
		//여러개의 객체를 만들지 않고 하나의 객체를 사용하기 위해서 싱글톤을 씀.
	}
}
