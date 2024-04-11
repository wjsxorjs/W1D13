package am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReaderWriter_Ex5 {

	public static void main(String[] args) {
		// 파일 경로
		String path_r = "C:/My_Study/Java_Study/work/Ex20240411/src/am/ReaderWriter_ex5.java";
		
		String path_w = "C:/My_Study/io_test.txt";
		
		// 필요한 스트림들 준비
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			
			// 읽기를 위한 스트림 생성
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path_r)));
			
			// 쓰기를 위한 스트림 생성
			bw = new BufferedWriter(new PrintWriter(path_w));
			
			String str = null;
			
			while((str = br.readLine()) != null) {
				// readLine() 함수는 더 이상 읽을 자원이 없을 때
				// null을 반환한다.
				
				bw.write(str);
				bw.write("\r\n");
				bw.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) {
					br.close();
				}
				if(bw!=null) {
					bw.close();
				}
			} catch (Exception e) {}
		}
		System.out.println("복사 끝");
	}

}
