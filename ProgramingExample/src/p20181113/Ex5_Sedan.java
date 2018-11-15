package p20181113;
//Car를 상속받은 자식 클래스
public class Ex5_Sedan extends Ex5_Car{
	
	private int seat;
	
	public Ex5_Sedan(String color, int speed, int seat) {
		super(color,speed);
		this.seat = seat;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	


}
