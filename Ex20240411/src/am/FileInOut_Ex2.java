package am;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class FileInOut_Ex2 {
	
	public static void main(String[] args) throws Exception {
		// 웹상의 경로 준비
		String path = "https://upload.wikimedia.org/wikipedia/commons/f/fa/Church_of_light.jpg";
		
		// Java에서 웹상의 경로(URL)를 객체화
		URL url = new URL(path);
//		System.out.println(path.substring(path.lastIndexOf("/")+1)); // 파일이름 따로 빼내기
		
		// 웹에 있는 이미지를 '읽어'들여서 로컬PC에 '저장'
		// 읽기/쓰기를 위한 각 스트림 준비
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		bis = new BufferedInputStream(url.openStream());
		bos = new BufferedOutputStream(new FileOutputStream("C:/My_Study/"+path.substring(path.lastIndexOf("/")+1)+""));
		
		byte[] buf = new byte[4096];
		int size = -1;
		
		while((size = bis.read(buf)) != -1) {
			bos.write(buf, 0, size);
			bos.flush();
		}
		if(bis != null) {
			bis.close();
		}
		if(bos != null) {
			bos.close();
		}
		
		System.out.println("웹상 파일 읽기 / 로컬 디스크에 쓰기 완료");
		
		
	}

}
