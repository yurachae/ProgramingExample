package p20181108;

import java.util.Scanner;

public class EnglishWord {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String word[][] = { { "chair", "의자" },{"desk","책상"}, { "water", "물" }, { "monitor", "모니터" }, { "mouse", "마우스" } };
		int count = 0;

		for (int i = 0; i < word.length; i++) {
			System.out.print("문제"+(i+1)+". "+word[i][0] + "의 뜻은 무엇인가요?");
			String answer = scan.nextLine();
			if (word[i][1].equals(answer)) {
				System.out.println("정답입니다.");
				count++;
			} else {
				System.out.println("틀렸습니다.");
				System.out.println("정답은 " + word[i][1] + "입니다.");
			}
		}
		System.out.println("총 "+count+"개를 맞췄습니다.");
		System.out.println("정답률은 " + ((double)  count/(word.length))*100  + "% 입니다.");
	}

}
