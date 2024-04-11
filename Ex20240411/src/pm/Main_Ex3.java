package pm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main_Ex3 {

	public static void main(String[] args) {
		// 저장할 객체 생성
		DataVO vo1 = new DataVO();
		vo1.setName("AAA");
		vo1.setValue(111);
		
		DataVO vo2 = new DataVO();
		vo2.setName("BBB");
		vo2.setValue(222);
		
		DataVO vo3 = new DataVO();
		vo3.setName("CCC");
		vo3.setValue(333);
		
		//ArrayList 준비
		ArrayList<DataVO> list = new ArrayList<DataVO>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		//저장할 파일을 준비
		
		String path = "C:/My_Study/io_test.txt";
		File f = new File(path);
		
		// 객체저장 스트림 준비
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
			
			// 객체 저장
			oos.writeObject(list);
			oos.flush();
			System.out.println("저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
				}
			} catch (Exception e2) {}
		}
		
		
		

	}

}
