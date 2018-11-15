package p20181115;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Map 이용한 단어장 프로그램 작성
// 영단어 입력하면 한글 뜻 출력
// 없는 영단어 입력하면 단어장에 없습니다. 출력

public class Ex2_MapExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<String, String> word = new HashMap<String, String>();
		word.put("absence", "부재");
		word.put("absolute", "완전한");
		word.put("arrange", "정리하다");
		word.put("congenial", "마음이 맞는");

		while (true) {
			System.out.println("<끝내려면 q 입력>");
			System.out.print("입력>>");
			String in = scan.next();

			if (!in.equals("q")) {
				if (word.get(in) == (null)) {
					System.out.println("단어장에 없습니다.");
				} else {
					System.out.println(word.get(in));
				}
			}else {
				return;
			}
		}
	}
}
