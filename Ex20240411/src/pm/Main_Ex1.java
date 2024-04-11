package pm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main_Ex1 {

	public static void main(String[] args) {
		// 저장할 객체 생성
		DataVO vo = new DataVO();
		vo.setName("마루치");
		vo.setValue(100);
		
		// 저장할 파일 객체
		File f = new File("C:/My_Study/io_test.txt");
		
		
		// 객체를 저장하기 위해 객체스트림 준비
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
			
			oos.writeObject(vo); // vo라는 객체를 쓰게한다.
			oos.flush();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
				}
			} catch (Exception e) {}
		}
		
		System.out.println("객체 쓰기 완료");
		
	}

}
