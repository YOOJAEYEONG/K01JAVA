package ex16exception;

import java.io.IOException;

/*
예외처리방법 3]
	예외가 발생한 위치에서는 처리하지 않고 외부로 던지고,
	함수를 호출한 지점에서 예외 객체를 받은 후 처리한다.
	이때 예외 발생과 상관없이 finally절이 실행된다.

 */
public class Ex03ExceptionCase3 {

	static void compileFunc() throws IOException {
		
		try {
			System.out.println("하나의 문자를 입력하세요");
			
			int userChar = System.in.read();
			//read()는 자체적으로 예외처리를 갖고있기 때문에 본 예제에서는
			//단순 이해를 하는 용도로 생각하자
			System.out.println("입력된문자는:"+ (char)userChar);
			
		} 
		finally {
			System.out.println("예외발생? 난 몰라...!");
			
		}
	}
	
	public static void main(String[] args) {
		
		try {
			compileFunc();
			compileFunc();
			compileFunc();
			compileFunc();
			compileFunc();
//			   . . .
			
			
		} catch (IOException e) {
			System.out.println("compileFunc()메소드에서 예외발생됨");
		}
	}
}














