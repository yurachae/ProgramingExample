package p20181113;
//Car를 상속받은 자식 클래스
public class Ex5_Truck extends Ex5_Car {
	
	private int amount;
	
	public Ex5_Truck(String color, int speed, int amount) {
		super(color, speed);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int amountCount () {
		return amount;
	}
}
