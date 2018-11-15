package p20181112;

import java.util.Scanner;

public class Ex01_TwoPointExample {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Ex01_TwoPoint method = new Ex01_TwoPoint();
		int p1x;
		int p1y;
		int p2x;
		int p2y;
		
		while(true) {
			System.out.println("-----------------------");
			System.out.println("1. 두점 사이의 거리 구하기 " );
			System.out.println("2. 절대값 구하기 ");
			System.out.print("선택>> ");
			int select = scan.nextInt();
			
			
			if(select == 1) {
				System.out.println("두 점을 (x,y)순으로 입력해주세요.");
				System.out.print("첫 번째  x좌표 : ");
				p1x = scan.nextInt();
				System.out.print("두 번째  y좌표 : ");
				p1y = scan.nextInt();
				System.out.print("첫 번째  x좌표 : ");
				p2x = scan.nextInt();
				System.out.print("두 번째  y좌표 : ");
				p2y = scan.nextInt();
				
				System.out.println("두 점 사이의 거리는 "+method.distance(p1x, p1y, p2x, p2y)+"입니다.");
				
			}else if(select ==2){
				System.out.println("정수를 입력해주세요. ");
				p1x = scan.nextInt();
				System.out.println("입력하신 정수의 절댓값은 "+Math.abs(p1x)+"입니다.");
			}
		}
	}
}
