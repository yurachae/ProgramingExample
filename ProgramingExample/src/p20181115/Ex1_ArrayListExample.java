package p20181115;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1_ArrayListExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> name = new ArrayList<String>();
		int max =0;	

		for (int i = 0; i < 5; i++) {
			System.out.print("이름 입력 : ");
			name.add(scan.next());
			if(max<name.get(i).length())
				max = name.get(i).length();
		}
		
		for(int i =0; i< name.size(); i++) {
			System.out.println(name.get(i));
		}
		
		for(int i =0; i< name.size(); i++) {
			if(name.get(i).length() == max)
				System.out.println("가장 긴 이름 :"+ name.get(i));
		}

		
		
	}
}
