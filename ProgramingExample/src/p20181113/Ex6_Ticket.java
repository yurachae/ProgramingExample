package p20181113;
//부모 클래스
//티켓 번호와 가격 정보를 가지고 있음.
//티켓 가격은 변경 가능함.
public class Ex6_Ticket {

	private String ticketNumber;
	private double ticketPrice;
	
	//생성자
	Ex6_Ticket(String ticketNumber ) {
		this.ticketNumber = ticketNumber;
	}
	
	//가격 변경 메소드
	public void changePrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	
	
	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
}
