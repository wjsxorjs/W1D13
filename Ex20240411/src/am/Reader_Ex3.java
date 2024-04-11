package am;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reader_Ex3 {

	public static void main(String[] args) {
		// 키보드(System.in)로부터 한 줄을 입력받음
		// 한 줄을 받기 위해 Reader를 준비
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
												// InputStreamReader는 InputStream을 받아서
												// Reader로 변화하는 스트림이다.
		try {
			System.out.print("입력: ");
			String str = br.readLine();
			
			System.out.print("받은 값: ");
			System.out.println(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (Exception e2) {}
			
		}
		
		
		

	}

}
