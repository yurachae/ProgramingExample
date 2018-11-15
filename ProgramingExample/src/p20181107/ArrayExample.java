package p20181107;

import java.util.Scanner;

public class ArrayExample {
	public static void main(String[] args) {
		int array[] = new int[4];
		int sum =0;
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<array.length; i++ ) {
			System.out.print((i+1)+"번째 숫자를 입력하세요 : ");
			array[i] = scan.nextInt();
		}
		for(int i=0; i< array.length; i++) {
			sum += array[i];
		}
		
		System.out.println("합계 ==>"+sum);
	}

}
