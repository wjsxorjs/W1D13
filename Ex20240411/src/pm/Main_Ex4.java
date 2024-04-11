package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main_Ex4 {

	public static void main(String[] args) {
		
		
		String path = "C:/My_Study/io_test.txt";
		File f = new File(path);
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			// 준비된 파일로부터 객체 1개 읽기
			Object obj = ois.readObject(); // 읽을 때는 readObject
			
			if(obj instanceof ArrayList) {
				ArrayList<DataVO> list = (ArrayList<DataVO>) obj;
				
				for(int i=0; i<list.size();i++) {
					DataVO vo = list.get(i);
					
					System.out.printf("Name: %s || Value: %d\r\n",vo.getName(),vo.getValue());
					
				} // for의 끝
				System.out.println("\r\n---------- 끝 ----------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		

	}

}
