package p20181113;

//스톡 옵션 있음. (자사 주식을 살 수 있는 권리)
//급여 인상율 30%
public class Ex7_Excutive extends Ex7_Manager {
	boolean stock;

	Ex7_Excutive(String name, int price) {
		super(name,price);
	}
	

	@Override
	public void priceRise() {
		setPrice((int)(getPrice() * 1.3));
	}
	
	public void	stockOption() {
		if(stock) {
			System.out.println("있음.");
		}else {
			System.out.println("없음");
		}
	}
}
