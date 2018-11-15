package p20181113;
//부모 클래스
public class Ex5_Car {
	private String color;	//차 색
	private int speed;		//차의 속도
	
	public Ex5_Car(String color, int speed) {
		this.color = color;
		this.speed = speed;
	}
	
	//gatter, setter 메소드
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	//속도 증가 처리용 메소드
	public void speedup(int speed) {
		this.speed += speed;
	}
	
	//속도 감소 처리용 메소드
	public void speedDown(int speed) {
		if(this.speed-speed>0)
			this.speed -=speed;
		else
			this.speed =0;
	}
}
