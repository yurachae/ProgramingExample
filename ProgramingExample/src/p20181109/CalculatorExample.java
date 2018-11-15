package p20181109;

import java.util.Scanner;

// 메소드를 호출해서 결과 출력하기.
public class CalculatorExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calculator cal = new Calculator();
		
		System.out.println("숫자 2개 입력");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		int sum = cal.sum(num1, num2);
		int minus = cal.minus(num1,num2);

		System.out.println(cal.power(true));
		System.out.println("덧셈 ="+sum);
		System.out.println("뺄셈 ="+minus);
		System.out.println(cal.power(false));
	}
}
