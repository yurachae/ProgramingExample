package p20181113;

public class Ex3_Computer extends Ex3_Calculator {
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return 3.141592*r*r;
	}
}
