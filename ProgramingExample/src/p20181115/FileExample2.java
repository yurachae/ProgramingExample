package p20181115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//기존 파일 없애고 새로운 파일 만들기
public class FileExample2 {
	public static void main(String[] args) {
		File oldFile = new File("D:\\test\\testfile.txt"); //이전 파일 객체 생성
		File newFile = new File("D:\\test\\testfile_new.txt");	//새로운 파일 객체 생성
		
		try {
			//기존 파일 읽어오기
			//기존의 파일을 가져와서 버퍼에 저장.
			//스트림 : 입력되는 흐름/출력되는 흐름.
			BufferedReader br = new BufferedReader(new FileReader(oldFile));
			
			//새로운 파일을 쓰기 위한 객체 생성
			BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
			
			//파일에서 읽어온 내용을 저장하기 위한 변수 선언.
			String content;
			while( (content = br.readLine())!= null) {
				bw.write(content +"새로운 내용");
			}
			
			br.close();
			bw.close();
			oldFile.delete(); //기존 파일에 내용 삭제.
			System.out.println("파일 쓰기 완료");
			
		}catch(Exception e) {
			e.printStackTrace();//예외 메세지 출력
		}
	}
}
