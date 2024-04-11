package am;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInOut_Ex1 {

	public static void main(String[] args) {
		// 읽어들일 파일의 경로를 준비
		String path = "C:/My_Study/Java_Study/work/Ex20240411/src/am/FileInOut_Ex1.java";
		File f = new File(path);
		
		// 쓰기할 파일의 경로 준비
		String path2 = "C:/My_Study/io_test.txt";
		
		// 파일 처리를 위한 각 스트림 준비
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(f));
			bos = new BufferedOutputStream(new FileOutputStream(path2));
			// FileOutputStream은 생성되면 해당 파일이 무조건 만들어진다.
			// 그래서 기존 파일이 새로 만들어지는 파일에 의해 덮어쓰기가 된다.
			
			// 읽기에 필요한 변수들
			byte[] buf = new byte[2048];
			int size = -1;
			
			while((size = bis.read(buf)) != -1) {
				// 읽은 자원들은 buf에 있다.
				// 이것을 bos를 통해 파일에 쓰기를 수행
				bos.write(buf, 0, size); // buf에서 0번지부터 size 길이만큼만 쓰기
				bos.flush(); // 스트림 비우기
			}
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if(bis != null) {
						bis.close();
					}
					if(bos!=null) {
						bos.close();
					}
				} catch (Exception e) {}
			}
			
			System.out.println("읽고/쓰기 끝");
		
		
	}

}
