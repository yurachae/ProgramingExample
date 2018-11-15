package p20181113;

//각 직급별 직원에 대한 객체를 만들어서
//급여를 인상해주고
//각 직원의 이름, 급여, 보너스 , 스톡옵션을 각각 출력.
public class Ex7_EmployExample {
	public static void main(String[] args) {

		// 직원
		Ex7_Employee worker = new Ex7_Employee("김사원", 3000000);
		worker.priceRise();

		// 매니저
		Ex7_Manager manager = new Ex7_Manager("김매니저", 5000000);
		manager.bonus = 500000;
		manager.priceRise();

		// 임원
		Ex7_Excutive excutor = new Ex7_Excutive("김임원", 8000000);
		excutor.stock = true;
		excutor.priceRise();

		System.out.println("<사원>");
		System.out.println("이름 : " + worker.getName());
		System.out.println("월급 : " + worker.getPrice());
		System.out.println();

		System.out.println("<매니저>");
		System.out.println("이름 : " + manager.getName());
		System.out.println("월급 : " + manager.getPrice());
		System.out.println("보너스 : " + manager.bonus);
		System.out.println();

		System.out.println("<임원>");
		System.out.println("이름 : " + excutor.getName());
		System.out.println("월급 : " + excutor.getPrice());
		System.out.print("스톡옵션 : ");
		excutor.stockOption();
		System.out.println();
	}
}
