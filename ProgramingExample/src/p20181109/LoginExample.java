package p20181109;

import java.util.Scanner;

public class LoginExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Login login = new Login();

		login.setId("yourid");
		login.setPass("12345");

		while (true) {
			System.out.println("-------------------");
			System.out.println("수행할 서비스를 선택해주세요.");
			System.out.println("1.로그인 ||2.로그아웃 ");
			System.out.print(">>");
			int select = scan.nextInt();
			if(select==1) {
				System.out.print("아이디를 입력하세요: ");
				String id = scan.next();
				System.out.print("비밀번호를 입력하세요: ");
				String pass= scan.next();
				
				login.login(id, pass);
			}
			else if(select==2) {
				login.logout();
			}
			else {
				System.out.println("다시 선택하세요.");
			}
		}
	}
}
