package p20181106;

import java.util.Scanner;

public class Baekjoun2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int month = scan.nextInt(); // 월
		int day = scan.nextInt(); // 일
		int days = 0;

	
		for (int i = 1; i < month; i++) {
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				days += 31;
			} else if (i == 4 || i == 6 || i == 9 || i == 11) {
				days += 30;
			} else
				days += 28;
		}
		days += day;

		System.out.println(days);

		if (days % 7 == 1) {
			System.out.println("MON");
		} else if (days % 7 == 2) {
			System.out.println("TUE");
		} else if (days % 7 == 3) {
			System.out.println("WEN");
		} else if (days % 7 == 4) {
			System.out.println("THU	");
		} else if (days % 7 == 5) {
			System.out.println("FRI");
		} else if (days % 7 == 6) {
			System.out.println("SAT");
		} else if (days % 7 == 7) {
			System.out.println("SON");
		}
	}

}
