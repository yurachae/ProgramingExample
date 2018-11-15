package p20181113;
//직원의 이름, 급여 정보를 갖고 있음.
//급여 인상에 대한 메소드 가짐.(10%)
public class Ex7_Employee {
	private String name;
	private int price;
	
	Ex7_Employee(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	//급여 인상 메소드
	public void priceRise() {
		setPrice((int)(getPrice()*1.1));
	}
}
