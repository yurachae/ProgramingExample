package p20181113;

import java.time.LocalDateTime;

public class Ex6_TicketExample {
	public static void main(String[] args) {
		Ex6_WalkUpTicket walkupticket = new Ex6_WalkUpTicket("111", true);
		Ex6_AdvancedTicket advancedticket = new Ex6_AdvancedTicket("222", LocalDateTime.of(2018,11,1,0,0,0));
		
		if(walkupticket.creditcard) {
			walkupticket.changePrice(20000);	
		}else {
			walkupticket.setTicketPrice(20000);
		}
		
		System.out.println(walkupticket.getTicketNumber());
		System.out.println(walkupticket.getTicketPrice());
		System.out.println();
		
		advancedticket.changePrice(30000);		
		System.out.println(advancedticket.getTicketNumber());
		System.out.println(advancedticket.getTicketPrice());
		
		
	}
}
