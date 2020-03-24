package ex20io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


/* 
바이트 스트림에서 할 수있는 모든일은 문자 스트림에서 할 수있다.
바이트 스트림에서 만든 bin파일은 자바에서만 오픈이 가능하므로
이를 문자스트림을 통해 만들면 윈도우나 다른 OS에서도 사용이 가능해진다
 */
public class E07FileReaderStream {

	public static void main(String[] args) {

		try {
			//버퍼로 사용할 char형 배열을 생성. 
			char[] cbuf = new char[10];
			int readCnt;
			//txt파일을 대상으로 문자 입력 스트림을 생성
			Reader in = new FileReader("src/ex20io/alpha.txt");
			
			//배열 cbuf의 0번 인덱스부터 배열의 크기 까지 읽어서 저장한다.
			readCnt = in.read(cbuf, 0, cbuf.length);
//			readCnt = in.read(cbuf, 0, 10);
			
			for(int i = 0; i<readCnt ; i++) {
				System.out.println(cbuf[i]);
			}
			in.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일없음");
		} catch (IOException e) {
			System.out.println("IO오류발생");
		}
	}
}


































