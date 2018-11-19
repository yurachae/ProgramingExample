package shopEx;

//Product 추상 클래스를 상속받아 구현한 CellPhone 클래스
public class CellPhone extends Product {
	String carrier;
	
	public CellPhone(String pname, int price, String carrier) {
		this.pname = pname;
		this.price = price;
		this.carrier = carrier;
	}

	@Override
	public void printExtra() {
		System.out.println("통신사: "+carrier);
	}

}
