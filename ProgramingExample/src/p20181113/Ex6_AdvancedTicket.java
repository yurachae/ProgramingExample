package p20181113;

import java.time.LocalDateTime;
import java.time.Period;

//Ticket 상속받기
//사전 예약 티켓.
//티켓 번호와사전 예약 일수 정보를 가지고 있음.
//언제 예매 했느냐에 따라 가격이 달라짐.
//30일전 : 50% 10일전 20% 5일전 10% => 할인
public class Ex6_AdvancedTicket extends Ex6_Ticket {
	LocalDateTime date;

	public Ex6_AdvancedTicket(String ticketNumber,  LocalDateTime date) {
		super(ticketNumber);
		this.date = date;
	}

	@Override
	public void changePrice(double ticketPrice) {
		LocalDateTime show = LocalDateTime.of(2018, 12,31, 18, 0, 0);
		Period remain = Period.between(show.toLocalDate(), date.toLocalDate());
		double price;
		

		if (remain.getDays() >= 30 || remain.getMonths() >= 1) {
			System.out.println("50% 할인");
			price = ticketPrice - (ticketPrice * 0.5);
			super.changePrice(price);
		} else if (remain.getDays() <= 10 && remain.getMonths() < 1) {
			System.out.println("20% 할인");
			price = ticketPrice - (ticketPrice * 0.2);
			super.changePrice(price);
		} else if (remain.getDays() <= 5 && remain.getMonths() < 1) {
			System.out.println("10% 할인");
			price = ticketPrice - (ticketPrice * 0.1);
			super.changePrice(price);
		}

	}

}
