package p20181108;

public class starPrint {
	public static void main(String[] args) {
		
		int num = 10;
		for(int i =0; i<num; i++) {
			for(int j =0; j<num-1; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
