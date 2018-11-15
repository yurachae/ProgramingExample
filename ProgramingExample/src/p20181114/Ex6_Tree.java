package p20181114;

public class Ex6_Tree extends Ex6_Countable {
	String name;
	
	Ex6_Tree(String name){
		this.name = name;
	}
	
	public void ripen() {
		System.out.println(this.name+"의 열매가 잘 익었다.");
	};
	
	@Override
	public void count() {
		System.out.println(this.name+"가 5그루 있다");
	}

}
