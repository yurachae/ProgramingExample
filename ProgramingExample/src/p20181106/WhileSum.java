package p20181106;
//1+(-2)+3+(-4)+5...
public class WhileSum {
	public static void main(String[] args) {
		int sum = 0;
		int s = 1;
		int num = 0;
		/*while (sum < 100) {
			if (i % 2 == 0) { // 짝수면 -
				sum -= i;
				i++;
			} else { // 음수면 +
				sum += i;
				i++;
			}
		}
		i--;	//whild문 빠져나올 조건이 100이상 일 때의 n값이 되므로 -1 하기.
		System.out.println(i);*/
		
		for(int i =1;true; i++) {
			num = i*s;
			sum += num;
			s = -s; //양수, 음수 번갈아 가면서 나오도록 
			System.out.println(num);
			if(sum>=100) {
				break;
			}
		}
		System.out.println("num "+num);
		System.out.println("sum "+sum);
	}

}
