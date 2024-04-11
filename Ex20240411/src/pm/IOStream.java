package pm;

public class IOStream {

	/*
		입출력 = Stream					생성시-> FileInputStream
				   	- 바이트기반 		/
				   		- BufferedInputStream 	: read(byte[] buf)
				   		- BufferedOutputStream 	: write(buf, 0, size)
				   				|
				   			생성시-> FileOutputStream
				   
				   
				   					생성시-> InputStreamReader(inputStream)
				   	- 문자 기반		/
				   		- BufferedReader :  readLine() -> 한 줄 처리
				   		- BufferedWriter :  write(String)	| 두 함수는
				   					|		flush()			| 한 세트다.
								생성시-> PrintWriter : 유연한 사용 가능
	
	
	입출력의 마무리는 객체직렬화? < 너무나 중요하다??
	
	객체직렬화 : 객체스트림 사용
	
	
	
	/-------------------|														보내려는 객체 안에 다른 객체가 있다면
	|		JAVA        |														보내고자 하는 객체가 시리얼화 되더라도
	|					|	<	보내고자 하는 객체		/-------|				보내지 못한다.
	|		[객체]		--------------------------------`		|
	|					________________________________		|				간단한 비유로, 객체를 자르려 할 때
	|					|		Serializable을 			|  객체 |				시리얼라이징을 통해 쇠꼬챙이를 빼야한다.
	|					|		구현하고 있어야함		|_______|
	|___________________|
	
	
	객체를 입출력하기 위해서는 일렬로 되어있는 바이트로 변경해야하는데, 이를 직렬화라고 한다.
	
	JAVA가 제공하는 객체는 모두 Serializable 되어있다.
	
	Serializable은 인터페이스로 해당 인터페이스를 구현한 객체만 직렬화가 가능하다.
	
	
	
	
	
	*/
}
