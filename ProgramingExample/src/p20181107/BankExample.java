package p20181107;

import java.util.Scanner;

public class BankExample {
	public static void main(String[] args) {
		int balance=0;
		int input;
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("=========================");
			System.out.println("1.예금 |2.출금|3.잔고|4.종료");
			System.out.println("=========================");

			int num = scan.nextInt();

			switch (num) {
			case 1:
				System.out.print("예금액>");
				input =scan.nextInt();
				balance += input;
				break;
			case 2:
				System.out.print("출금액>");
				input =scan.nextInt();
				
				if(balance-input >0) {
					balance-=input;
					System.out.println("출금했습니다.");
					System.out.println("현재 잔액은 "+balance+"입니다.");
				}else {
					System.out.println("잔고가 부족합니다.");
					System.out.println("현재 잔액은 "+balance+"입니다.");
				}		
				break;
			case 3:
				System.out.println("현재 잔액은 "+balance+"입니다.");
				break;
			case 4:
				System.out.println("종료 합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("다시 선택해 주세요(1~4번)");
				continue;
			}

		}
	}
}
