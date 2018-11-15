package p20181113;
//보너스 있음.
//급여 인상율 20%
public class Ex7_Manager extends Ex7_Employee {
	int bonus;
	public Ex7_Manager(String name, int price) {
		super(name,price);
	}
	
	@Override
	public void priceRise() {
		setPrice((int)(getPrice()*1.2));
	}

}
