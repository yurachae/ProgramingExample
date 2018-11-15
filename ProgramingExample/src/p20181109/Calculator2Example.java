package p20181109;

import java.util.Scanner;

public class Calculator2Example {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calculator2 cal = new Calculator2();
		
		int squareNum;
		int rectangleNum1;
		int rectangleNum2;
		
		System.out.println("정사각형 한 변의 길이 입력 :");
		squareNum = scan.nextInt();
		System.out.println("정사각형  넓이는 "+cal.rectangle(squareNum)+"입니다.");
		
		System.out.println("직사각형 두 변의 길이 입력 :");
		rectangleNum1 = scan.nextInt();
		rectangleNum2 = scan.nextInt();		
		System.out.println("직사각형  넓이는 "+cal.rectangle(rectangleNum1, rectangleNum2)+"입니다.");
		
	}
}
