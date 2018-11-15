package p20181107;

import java.util.Scanner;

//입력 받은 숫자를 내림차순으로 정렬하기.
public class descArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num[] = new int[5];
		int max = 0;
		int temp;

		System.out.println("양수 5개를 입력하세요.");
		for (int i = 0; i < num.length; i++) {
			num[i] = scan.nextInt();
		}

		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] < num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}

}
