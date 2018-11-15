package p20181107;
////////https://www.acmicpc.net/problem/10809
import java.util.Scanner;

public class baekjoon4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputStr = scan.nextLine(); // 문자열 입력
		char atoz[] = new char[26];
		int[] num = new int[26];
		int replace[];
		char startA = 97; // a

		String str[] = inputStr.split(""); // 문자별로 배열에 저장(입력한 문자열을)
		replace = new int[atoz.length];

		for (int i = 0; i < atoz.length; i++) {
			atoz[i] = startA++; // a부터 z까지 배열에 담음.
		}

		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < atoz.length; j++) {
				String s = String.valueOf(atoz[j]);
				if (str[i].equals(s)) {
					replace[j] = i + 1;
				} else {
					if (replace[j] == 0)
						replace[j] = -1;
				}
			}
		}

		for (int i = 0; i < replace.length; i++) {
			System.out.print(replace[i] + " ");
		}

	}

}
