package ex21jdbc.callable;

import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class FunctionCall extends IConnectImpl{

	
	public FunctionCall() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			//1. callable 객체 생성
			/*
			? = call 함수명(?)
			첫번째 인자 : 함수 실행후 반환값 처리
			두번째 인자 : 함수 호출시 전달할 파라미터
			*/
			csmt = con.prepareCall("{? = call fillAsterik(?)}");
			//2. 반환값의 자료형 설정
			csmt.registerOutParameter(1, Types.VARCHAR);
			//3. in파라미터 설정
			csmt.setString(2, scanValue("아이디"));
			//4. 실행
			csmt.execute();
			//5. 반환값을 콘솔에 출력
			System.out.println("함수의 반환값: " + csmt.getString(1));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FunctionCall().execute();
		
		
	}

}