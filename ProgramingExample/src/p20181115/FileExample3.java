package p20181115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

//콘솔에 입력한 내용을 파일에 쓰기
public class FileExample3 {
	public static void main(String[] args) {
		System.out.println("파일 쓰기");
		System.out.print("저장할 파일명 입력 : ");
		//파일명 입력할 때는 파일의 확장자 까지.
		Scanner scan = new Scanner(System.in);
		String filename = scan.next(); // 입력 받음.

		System.out.println("저장은 마지막 라인에 q 입력하기");

		try {
			String path = "D:\\test\\" + filename;
			BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter( new FileWriter(path));
			String content;
			//데이터를 읽어서 q만 있는 라인이 있다면 종료하겠다는 조건.
			//반복문에 종료 조건을 주는 내용.
			while( !(content = reader.readLine()).equals("q")) {
				writer.write(content+"\r\n");//내용 넣고 enter
			}
			reader.close();
			writer.close();
			scan.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("파일 쓰기 종료");
		System.out.println("저장된 파일명은 "+filename+"입니다.");
	}
}
