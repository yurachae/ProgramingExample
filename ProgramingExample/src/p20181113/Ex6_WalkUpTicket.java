package p20181113;
//신용카드 사용 여부로 수수료 붙여서 가격 저장할 것.

public class Ex6_WalkUpTicket extends Ex6_Ticket {

	boolean creditcard;

	public Ex6_WalkUpTicket(String ticketNumber, boolean creditcard) {
		super(ticketNumber);
		this.creditcard = creditcard;
	}

	@Override
	public void changePrice(double ticketPrice) {
		System.out.println("수수료");
		double price = getTicketPrice() + (getTicketPrice() * 0.05);
		super.changePrice(price);
	}
}
