package p20181112;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02_StudentScoreExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ex02_StudentScore student ;
		ArrayList<Ex02_StudentScore> students = new ArrayList<Ex02_StudentScore>();
		Ex02_StudentScore stu[] = new Ex02_StudentScore[10] ;
		String name;
		int ko;
		int en;
		int math;
		int num=0;

		while (true) {
			System.out.println("하고 싶은 업무 선택 ");
			System.out.println("1. 이름 및 점수 등록 || 2. 학생목록 보기");
			System.out.print("선택>> ");
			int select = scan.nextInt();

			if (select == 1) {
				System.out.print("이름: ");
				name = scan.next();
				System.out.print("국어 점수: ");
				ko = scan.nextInt();
				System.out.print("영어 점수: ");
				en = scan.nextInt();
				System.out.print("수학 점수: ");
				math = scan.nextInt();
				
				student = new Ex02_StudentScore(name,ko,en,math);
				//students.add(num, student);
				stu[num++] =student;
			}
			else if(select ==2) {
				for(int i =students.size();i>0; i--) {
					System.out.print("이름: ");
					System.out.println(students.get(i).name);
					System.out.print("국어 점수: ");
					System.out.println(students.get(i).korean);
					System.out.print("영어 점수: ");
					System.out.println(students.get(i).english);
					System.out.print("수학 점수: ");
					System.out.println(students.get(i).math);
					
				}
			}
		}
	}
}
