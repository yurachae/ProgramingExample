package p20181109;

// 덧셈용 메소드, 뺄셈용 메소드, 전원 on, 전원 off 메소드 (단순 프린트)
public class Calculator {

	public char sum(int num1, int num2) {
		int sum = num1+ num2;
		return (char) sum;	
	}

	public int minus(int num1, int num2) {
		if (num1 > num2)
			return num1 - num2;
		else
			return num2 - num1;
	}
	
	public String power(boolean p) {
		if(p==true) {
			return "전원on";
		}else {
			return "전원off";
		}
	}
}
