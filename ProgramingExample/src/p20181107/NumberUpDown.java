package p20181107;

import java.util.Scanner;
//숫자 맞추기
public class NumberUpDown {
	public static void main(String[] args) {
		
		//0.0<=Math.random()<1.0
		//0 <= (int) (Math.random() * 100) < 100
		//1 <= (int) (Math.random() * 100) +1 <101
		int Rnum = (int) (Math.random() * 100) + 1;
		int num = 0; // 입력 받는 변수
		int count = 0; // 시도
		Scanner scan = new Scanner(System.in);

		while (Rnum != num) {
			System.out.print("1과 100사이의 값을 입력하세요:");
			num = scan.nextInt();
			count++;
			if (Rnum > num) {
				System.out.println("더 큰 수를 입력하세요");
			} else {
				System.out.println("더 작은 수를 입력하세요");
			}
		}
		System.out.println("맞췄습니다.");
		System.out.println("시도 횟수는 " + count + "번입니다.");
	}
}
