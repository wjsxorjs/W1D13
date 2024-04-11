package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main_Ex4 {

	public static void main(String[] args) {
		
		
		String path = "C:/My_Study/io_test.txt";
		File f = new File(path);
		
		ArrayList<DataVO> list = new ArrayList<>();
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			Object obj = ois.readObject();
			
			if(obj instanceof ArrayList) {
				list = (ArrayList<DataVO>) obj;
			}
			
			for(int i=0; i<list.size();i++) {
				DataVO vo = list.get(i);
				
				System.out.printf("Name: %s || Value: %d\r\n",vo.getName(),vo.getValue());
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
		

	}

}
