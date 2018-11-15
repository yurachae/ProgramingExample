package p20181112;

import java.util.Scanner;

public class BankApplication {

	private static Account[] account = new Account[100];
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;

		while (run) {
			System.out.println("=================================");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("=================================");
			System.out.print("선택>> ");
			int num = scan.nextInt();

			if (num == 1) {
				createAccount();
			} else if (num == 2) {
				accountList();
			} else if (num == 3) {
				desposit();
			} else if (num == 4) {
				withraw();
			} else if (num == 5) {
				System.out.println("프로그램 종료");
				run = false;
			}
		}
	}

	private static void createAccount() {
		Account newAccount;

		System.out.println("--------------------");
		System.out.println("계좌생성");
		System.out.println("--------------------");
		System.out.print("계좌번호 : ");
		String ano = scan.next();
		System.out.print("계좌주 : ");
		String owner = scan.next();
		System.out.print("초기입금액 : ");
		int balance = scan.nextInt();

		newAccount = new Account(ano, owner, balance);
		for (int i = 0; i < account.length; i++) {
			if (account[i] == null) {
				account[i] = newAccount;
				break;
			}
		}
		System.out.println("결과 : 계좌가 생성되었습니다.");

	}

	private static void accountList() {
		System.out.println("--------------------");
		System.out.println("계좌목록");
		System.out.println("--------------------");

		for (int i = 0; i < account.length; i++) {
			if (account[i] != null) {
				System.out.println(account[i].getAno() + "\t" + account[i].getOwner() + "\t" + account[i].getBalance());

			} else {
				break;
			}
		}
		System.out.println("결과 : 계좌 목록이 출력되었습니다.");
	}

	private static void desposit() {
		System.out.println("--------------------");
		System.out.println("예금");
		System.out.println("--------------------");

		System.out.print("계좌번호 : ");
		String ano = scan.next();
		System.out.print("입금액 : ");
		int balance = scan.nextInt();

		Account check = findAccount(ano);
		if (check != null) {
			check.setBalance(check.getBalance() + balance);

			System.out.println("결과 : 예금이 성공되었습니다.");
		}
	}

	private static void withraw() {

		System.out.println("--------------------");
		System.out.println("출금");
		System.out.println("--------------------");

		System.out.print("계좌번호 : ");
		String ano = scan.next();
		System.out.print("출금액 : ");
		int balance = scan.nextInt();

		Account check = findAccount(ano);
		if (check != null) {
			if (check.getBalance() >= balance) {
				check.setBalance(check.getBalance() - balance);

				System.out.println("결과 : 출금이 성공되었습니다.");
			} else {
				System.out.println("돈이 부족합니다. 다시 시도하세요.");
			}
		}


	}

	// Account 배열에서 ano와 동일한 Account 찾기
	private static Account findAccount(String ano) {

		Account check = null;
		for (int i = 0; i < account.length; i++) {
			if (account[i] != null) {
				if (account[i].getAno().equals(ano))
					check = account[i];
				else
					System.out.println("계좌가 없습니다.");
			}
		}
		return check;
	}

}
