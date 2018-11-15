package p20181109;

public class CarExample {
	public static void main(String[] args) {
		// 객체 생성
		Car car = new Car();
		boolean gas;
		
		// setGas 호출
		car.setGas(10);
		
		// isLeftGas 호출 결과 변수를 선언해서 담기
		gas = car.isLeftGas();
		
		// 선언된 변수로 run 출력
		car.run();
		

		
	}
}
