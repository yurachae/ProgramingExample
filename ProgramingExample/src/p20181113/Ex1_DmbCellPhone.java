package p20181113;

public class Ex1_DmbCellPhone extends Ex1_CellPhone{
	int channel;
	
	Ex1_DmbCellPhone(String model, String color, int channel){
		this.model = model;
		this.color = color;
		this.channel  = channel;
	}
	
	void DmbPrint() {
		System.out.println("자식클래스 DmbCellPhone 메소드");
	}
}
