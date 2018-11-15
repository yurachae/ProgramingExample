package p20181114;

public class Ex6_Bird extends Ex6_Countable {
	
	String name;
	
	Ex6_Bird(String name){
		this.name = name;
	}
	
	public void fly() {
		System.out.println("2마리 "+this.name+"날아간다.");
		
	};
	
	@Override
	public void count() {
		System.out.println(this.name+"가 2마리 있다.");
		
	}

}
