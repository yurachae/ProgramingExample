package p20181113;

public class Ex5_Main {
	public static void main(String[] args) {
		
		Ex5_Sedan sedan = new Ex5_Sedan("빨간색",0,0);
		Ex5_Truck truck = new Ex5_Truck("검정색",0,0);
		
		sedan.speedup(200);
		truck.speedup(100);
		
		sedan.setSeat(5);
		truck.setAmount(5);

		System.out.println(sedan.getColor()+" 승용차의 속도는 "+sedan.getSpeed()+"이고 좌석수는 "+sedan.getSeat()+"개 입니다.");
		System.out.println(truck.getColor()+" 트럭의 속도는 "+truck.getSpeed()+"이고 좌석수는 "+truck.getAmount()+"톤 입니다.");
	}

}
