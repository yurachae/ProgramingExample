package p20181108;

import java.util.Scanner;

public class StudentScoreManagement {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int student = 0; //
		int score[] = null; // 배열만 선언.
		boolean run = true;

		while (run) {
			System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.print("선택>>  ");
			int select = scan.nextInt();
			
			if(select == 1) {
				System.out.println("학생 수를 입력합니다.");
				System.out.println("학생 수>>  ");
				student = scan.nextInt();
				score = new int[student];	//입력한 학생 수 만큼 배열 생성
			}else if(select ==2){
				System.out.println("점수 입력을 합니다.");
				for(int i =0; i<score.length; i++) {
					System.out.println((i+1)+" 번째 학생 점수 :");
					score[i] = scan.nextInt();
				}				
			}else if(select ==3) {
				System.out.println("학생리스트를 출력합니다.");
				for(int i =0;i<score.length; i++) {
					System.out.println((i+1)+" 번째 학생 점수 :"+ score[i]);
				}				
			}else if(select ==4) {
				System.out.println("분석 합니다.");
				int sum = 0;
				double avg = 0;
				for(int i =0; i<score.length; i++) {
					sum += score[i];
				}
				avg = sum/score.length;
				System.out.println("학생 점수의 총 합 : "+sum);
				System.out.println("학생 점수의 평균 : "+avg);
				
			}else if(select ==5) {
				System.out.println("종료합니다.");
				run = false;
			}
		}
	}
}
