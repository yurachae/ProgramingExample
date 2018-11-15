package p20181107;
//Nkg의 설탕을 5kg, 3kg으로 가장 적은 갯수 주는 방법.

import java.util.Scanner;

public class Baekjoon3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("n 입력 : ");
		int n = scan.nextInt();
		ott: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (5 * i + 3 * j == n) {
					System.out.println(n + "kg = 5kg :" + i + "개 , 3kg :" + j + "개");
				} else {
					System.out.println("-1");
					break ott;
				}
			}
		}
	}
}
