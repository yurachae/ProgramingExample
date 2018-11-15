package p20181115;

import java.io.File;
import java.io.FileWriter;

//파일 입출력.

public class FileExample {
//텍스트 파일을 생성해서 내용을 채우기
	public static void main(String[] args) {

		// 생성된 파일의 위치와 주소를 담는 변수.
		String path = "D:\\test\\testfile.txt";

		// 파일 객체 생성
		// 자바 io 패키지 안에 있는 File이라는 클래스
		// File 클래스의 생성자는 String 값을 받고 그 값은 경로를 받음.
		File file = new File(path);

		try {
			// 바이트 단위로 파일을 쓰기 위해 FileWriter 스트림 생성
			// 한글은 처리 되지 않음.
			FileWriter fw = new FileWriter(file);
			for (int i = 'A'; i <= 'Z'; i++) {
				fw.write(i);
			}
			fw.close();
			System.out.println("파일 쓰기 완료");
		} catch (Exception e) {
			e.printStackTrace();// 오류 위치 출력.
		}
	}

}