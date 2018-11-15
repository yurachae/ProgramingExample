package p20181109;
//result() 메소드는 학생의 학점, 2과목의 점수를 각각 출력
//학점 기준은 평균이 90이상 A/ 80이상 B/ 70이상 C/ 나머지 F
public class Ex1 {
	
	String name;
	int score1;
	int score2;
	
	public Ex1(String name, int score1, int score2) {
		this.name = name;
		this.score1 =score1;
		this.score2 = score2;
	}
	public String grade(int score1, int score2) {
		int avg = (score1+score2)/2;
		if(avg>=90) {
			return "A";
		}else if(avg>=80) {
			return "B";
		}else if(avg>=70) {
			return "C";
		}else {
			return "F";
		}
	}
	
	public void result() {
		System.out.println(name+"의 평가입니다.");
		System.out.println("과목 1:"+ score1 +", 과목 2:"+score2);
		System.out.println("학점은 "+grade(score1,score2)+"입니다. ");
		System.out.println("====================================");
	}

}
