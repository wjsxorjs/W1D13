package am;

import java.io.BufferedWriter;
import java.io.PrintWriter;

public class Writer_Ex4 {

	public static void main(String[] args) {
		// 파일에 쓰기할 자원 준비
		String msg = "오늘은 월요일같은 목요일이에요. 너무 좋네요! 내일부터는 DB다...?";
		
		// 특정파일에 쓰기
		String path = "C:/My_Study/io_test.txt";
		
		BufferedWriter bw = null;
		try {
		bw = new BufferedWriter(new PrintWriter(path));
		// PrintWriter도 생성만 했을 때 파일을 생성한다.
		// 스트림을 통해 쓰기
		bw.write(msg);
		bw.flush();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("쓰기 완료!");

	}

}
