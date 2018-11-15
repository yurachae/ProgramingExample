package p20181106;

import java.util.Scanner;

//알고리즘
/* 1부터 10까지 반복
 * 숫자와 +까지 출력(1~9)
 * 10은 =와 같이 출력.
 * 
 *  */
public class SumFromOneToTen {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("시작 값: ");
		int start = scan.nextInt();
		System.out.print("종료 값: ");
		int end = scan.nextInt();
		
		int sum = 0;
		for (int i =start; i <= end; i++) {
			sum += i;
			if (i < end) {
				System.out.print(i + "+");

			} else {
				System.out.print(i + "=");
			}
		}
		System.out.println(sum);
	}
}
