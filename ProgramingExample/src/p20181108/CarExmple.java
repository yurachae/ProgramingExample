package p20181108;

public class CarExmple {
	public static void main(String[] args) {
		//클래스 생성
		CarClass car = new CarClass();
		
		//생성된 클래스의 필드 출력.
		System.out.println(car.name);
		System.out.println(car.color);
		System.out.println(car.maxSpeed);
		System.out.println(car.speed);
		
		car.speed = 10;
		System.out.println(car.speed);
		
	}
}
