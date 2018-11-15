package p20181114;

import java.util.Scanner;

public class Ex7_TryCatchExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1,num2;
		System.out.println("숫자 두개 입력");
		num1=scan.nextInt();
		num2 = scan.nextInt();
		
		double div = (double) num1/num2;
		System.out.println(div);
	}
}
