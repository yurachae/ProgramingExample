package p20181107;

import java.util.Scanner;

//점수, 학년을 입력 받아 60점 이상이면 합격, 미만이면 불합격
// 4학년은 70점 이상이어야 합격
public class PassNonpass {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int grade = 0; // 학년
		int score = 0; // 점수


		System.out.println("학년 입력 : ");
		grade = scan.nextInt();
		if (grade == 4) {
			System.out.println("점수 입력 : ");
			score = scan.nextInt();
			if (score >= 70) {
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}
		} else {
			if (score >= 60) {
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}

		}

	}

}
