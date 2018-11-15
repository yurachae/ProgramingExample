package p20181109;

public class Ex2_bankEx {
	//신규 계좌생성(이름,계좌번호,초기입금액10000)
	//3000원 추가 입금. 5000원 출금. 계좌 잔고 출력
	public static void main(String[] args) {
		Ex2_bank bank = new Ex2_bank();
	
		bank.setAccount_name("채유라");
		bank.setAccount_number("111-111-11111");
		bank.setBalance(10000);
		//입금
		bank.deposit(3000);
		//출금
		bank.withdraw(5000);
		//계좌확인
		bank.balacePrint();
	}
	
}
