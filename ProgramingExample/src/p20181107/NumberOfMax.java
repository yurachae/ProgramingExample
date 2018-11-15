package p20181107;

import java.util.Scanner;

public class NumberOfMax {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num[] = new int[5];
		int max = 0;

		System.out.println("양수 5개를 입력하세요.");
		for(int i =0; i<num.length; i++) {
			num[i] = scan.nextInt();
		}
		
		for(int i =0; i<num.length; i++) {
			if(max<num[i]) {
				max = num[i];
			}
		}
		System.out.println("가장 큰 수는 "+max+"입니다.");
	}

}
