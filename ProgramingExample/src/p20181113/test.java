package p20181113;

import java.util.Date;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Date anotherDate = new Date("2018-10-22");
		
		System.out.println(anotherDate.compareTo(date));
	}

}
