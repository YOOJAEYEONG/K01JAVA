package ex21jdbc.callable;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;


/*
java에서 프로시저 호출하기

[1]프로시저를 실행하기 위한 CallableStatement객체 생성
-프로시저 호출시에는 { call 프로시저명(?,?,? ...? ) }
-파라미터는 in, out 순으로 작성이 가능함. 즉, 프로시저 정의에 따라 달라진다.

[2]파라미터 설정
	2-1] in파라미터 설정 : ? 에 해당하는 순서대로 setter()로 설정함.
		setxxx(인덱스, 값);
	2-2] out 파라미터 설정 : 
		registerOutParameter(인덱스, java.sql.Types의 변수형)으로 자료형 설정
[3]프로시저 실행
	execute();
[4]out 파라미터에 저장된 값 불러오기
	getter()로 읽어옴
 */
public class InsertProcCall extends IConnectImpl{

	
	public InsertProcCall() {
		super("kosmo","1234");
	}
	
	@Override
	public void execute() {
		try {
			//1. callable 객체 생성
			/*
			프로시저는 return값이 없으므로 함수처럼 ?= 로 시작하지 않음
			return값 대신 out 파라미터를 통해 값을 반환 받음
			 */
			csmt = con.prepareCall("{ call KosmoMemberInsert(?,?,?,?) }");
			//2-1. in 파라미터 설정
			csmt.setString(1, scanValue("아이디"));
			csmt.setString(2, scanValue("패스워드"));
			csmt.setString(3, scanValue("이름"));
			//2-2. out 파라미터 설정(반환값의 자료형을 설정함)
			csmt.registerOutParameter(4, Types.NUMERIC);
			//3. 실행
			csmt.execute();
			//4. out파라미터의 할당된 값을 읽어서 결과를 출력한다.
			int affected = csmt.getInt(4);
			if(affected==0)
				System.out.println("오류발생:입력실패");
			else
				System.out.println(affected+"행 입력 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InsertProcCall().execute();
	}

}
