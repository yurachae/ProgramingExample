package p20181115;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("가나다");
		list.add("마바사");
		list.add("아자차카");
		list.add("타파하");
		
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
