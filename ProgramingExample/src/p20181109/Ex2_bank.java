package p20181109;

public class Ex2_bank {
	private String account_name;
	private String account_number;
	private int balance; //잔고

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public void deposit(int balance) {//입금
		this.balance += balance;
		System.out.println(balance+"원이 입금되었습니다.");
	}
	public void withdraw(int balance) { //출금
		this.balance -= balance;
		System.out.println(balance+"원이 출금되었습니다.");
	}
	public void balacePrint() {
		System.out.println("현재 잔고는 "+balance+"입니다.");
	}
	
	
}
