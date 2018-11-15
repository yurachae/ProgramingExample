package p20181106;

import java.util.Scanner;
//알고리즘. => 습관화하기
/* 1. 숫자 입력 : Scanner
 * 2. 입력 받은 숫자 0인지 확인하기
 * 3. 0이 아니면 sum에 저장하고 count+1하기
 * 4. 0이면 count-1 하기
 * 5. sum/count로 avg 계산하기.
 */ 
public class QuitZero {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		int count = 0;
		double avg = 0.0;
		boolean state = true;
		System.out.println("정수를 입력하고 마지막에 0을 입력하세요.");	
		int num ;
		/*while (state) {
			int num = scan.nextInt();
			if(num!=0) {				
				sum += num;
				++count;
			}else {
				state = false;
			}
		}*/
		
		while((num=scan.nextInt()) != 0) {
			sum+=num;
			count++;
			
		}
		avg = (double)sum/count;		
		System.out.println("개수 :"+count+" 평균 :"+avg);
	}
}
