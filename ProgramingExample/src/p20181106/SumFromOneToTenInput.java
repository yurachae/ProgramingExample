package p20181106;

//알고리즘
/* 1부터 10까지 반복
 * 숫자와 +까지 출력(1~9)
 * 10은 =와 같이 출력.
 * 
 *  */
public class SumFromOneToTenInput {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
			if (i < 10) {
				System.out.print(i + "+");

			} else {
				System.out.print(i + "=");
			}
		}
		System.out.println(sum);
	}
}
