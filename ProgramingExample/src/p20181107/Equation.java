package p20181107;

// 2x+4y = 10 방정식의 모든 해를 구하라.
public class Equation {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (2 * i + 4 * j == 10) {
					System.out.println("(" + i + "," + j + ")");
				}
			}
		}
	}
}
