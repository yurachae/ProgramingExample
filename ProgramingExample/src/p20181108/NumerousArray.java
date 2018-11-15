package p20181108;

import java.util.Scanner;

public class NumerousArray {
	public static void main(String[] args) {
		int scores[][] = new int[4][2];
		Scanner scan = new Scanner(System.in);
		int sum=0;
		
		//입력
		for(int i=0; i<scores.length; i++){
			System.out.println("<<"+(i+1)+"학년 성적 입력>>");
			for(int j=0; j<scores[i].length; j++) {
				System.out.print((j+1)+"학기 성적 입력 :");
				scores[i][j] = scan.nextInt();
			}
			System.out.println();
		}
		
		//합계
		for(int i=0; i<scores.length; i++ ) {
			for(int j=0; j<scores[i].length; j++) {
				sum += scores[i][j];
			}
		}
		
		//평균 계산 및 출력
		double avg = (double) sum/(scores.length*scores[0].length);
		System.out.println("평균 :"+avg);
	}
}	
