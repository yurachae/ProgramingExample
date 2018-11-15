package p20181113;

public class Ex2_Student extends Ex2_People {
	int studentNo;

	
	Ex2_Student(String name, String ssn, int studentNo){
		super(name,ssn);
		this.studentNo = studentNo;
	}
}
