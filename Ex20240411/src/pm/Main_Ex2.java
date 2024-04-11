package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main_Ex2 {

	public static void main(String[] args) {
		// 읽기할 파일의 경로
		String path = "C:/My_Study/io_test.txt";
		File f = new File(path);
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			
			// 객체읽어오기
			Object obj = ois.readObject();
			
			if(obj instanceof DataVO) {
				// obj가 가리키고 잇는 주소지에 DataVO가 존재하면 true가 발생
				// obj가 가리키는 주소지에 DataVO라는 객체가 있다면
				// 변수를 하나 만들어서 DataVO로 형변환
				
				DataVO vo = (DataVO) obj;
				String n = vo.getName(); // 마루치
				int v = vo.getValue()+1; // 101
				
				System.out.printf("name: %s || value: %d",n,v);
								
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch (Exception e2) {}
		}
		
		
		
		
		
	}

}
