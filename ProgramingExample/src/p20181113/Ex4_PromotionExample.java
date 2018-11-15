package p20181113;

//형변환 예제
//클래스
class A {
}

class B extends A {
}

class C extends B {
}

class D extends B {
}

class E extends C {
}

public class Ex4_PromotionExample {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();

		// 자동 타입 변환
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;

		// 강제 타입 변환
		b = (B) a1;
		c = (C) a1;
		d = (D) a1;
		e = (E) a1;
	}
}
