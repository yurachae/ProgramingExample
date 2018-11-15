package p20181109;

public class Calculator1 {
	int plus(int num1, int num2) {
		int result = num1+num2;
		return result;
	}
	
	double avg(int num1,int num2) {
		double sum = plus(num1, num2);
		double result = (double)sum/2;
		return result;
	}
	
	void execute() {
		double result = avg(7,10);
		println("실행결과 :"+result);
	}
	
	void println(String message) {
		System.out.println(message);
	}
	
	
}
