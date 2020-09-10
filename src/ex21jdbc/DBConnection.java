package ex21jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{

		/*
		 JDBC 프로그래밍 절차
		  
		 1] 오라클용 JDBC드라이버를 메모리에 로드함
		  	: new를 사용하지 않고 클래스명으로 직접 찾아서 객체생성후
		  	메모리에 로드하는 forName()메소드를 사용한다. 메모리에
		  	로딩된 드라이버가 DriverManager라는 클래스에 등록된다.
		  	정적 블록을 갖는 클래스들은 Class.forName() 만 호출해도 초기화가 수행된다
			Class.forName()을 호출하면 Driver 가 자기자신을 초기화하여 DriverManager에 등록을 한다.
			즉 개발자가 따로 관리하지 않는 static 객체들이 알아서 DriverManager에 등록이 되는 것이다.
			그래서 Class.forName()을 호출하고 나서 어떠한 인자로도 전달하지 않고
			바로 getConnection()을 호출해도 드라이버가 찾아지는 것이다.
		 */
		Class.forName("oracle.jdbc.OracleDriver");
		
		/*
		2] 오라클에 연결하기위한 커넥션URL, 계정ID, 패스워드를 준비한다.
			커넥션URL => jdbc:oracle:thin://@IP주소:포트번호:SID
			***서버환경에 따라 IP주소, 포트번호, SID는 변경될 수 있다.
		 */
		//String url = "jdbc:oracle:thin://@localhost:1521:orcl";
		//String userid = "hr";
		//String userpw = "1234";
		String url = "jdbc:oracle:thin:@alouerdb.ct7ir1xc2f4m.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
		String userid = "aliuerUser";
		String userpw = "T3sshutd0n?";
		/*
		2-1] DriverManager클래스의 getConnection()메소드를 호출하여
			오라클에 연결을 시도한다. 연결에 성공할 경우 연결된 주소를 반환한다.
		 */
		Connection con = DriverManager.getConnection(url, userid, userpw);
		
		if(con!=null) {
			System.out.println("Oracle DB 연결성공");
			
			/*
			3]쿼리문 작성
				: 쿼리문을 작성할때 주의할 점은 줄바꿈을 할때 앞뒤로 공백을 삽입하는것이 좋다.
				그렇지 않으면 서로 문장이 이어져 SyntaxError가 발생하게 된다.
			 */
			String sql = 
					" select * from employees where department_id=50 "+
					" order by employee_id asc";
			//쿼리문을 작성할때 문자열에서 공백이 없어 실수가 많이 발생한다. 그냥 앞뒤로 무조건 띄워쓰면 편함
			
			/*
			4] 쿼리문을 전송을 위한 Statement계열의 객체를 생성한다.
				해당 객체는 주로 정적인 쿼리를 실행할때 사용된다.
			 */
			Statement stmt = con.createStatement();
			/*
			5] Statement 객체를 사용하여 오라클로 작성된 쿼리문을 전송한다.
				오라클은 전송받은 쿼리를 실행후 결과를 반환하는데 이를 ResultSet 객체를 통해 받는다.
			 */
			ResultSet rs = stmt.executeQuery(sql);//executeQuery()가 오라클로 쿼리문을 전달함
			while(rs.next()) {

				/*
				오라클이 반환해준 ResultSet객체의 갯수만큼 반복하면서 콘솔에
				출력한다. getXXX()계열의 함수의 인자로는 select절의 순서대로
				'인덱스'를 쓸수 있고, '컬럼명'을 사용할 수도 있다.
				 */
				//오라클의 자료형은 숫자,날짜,문자3개 뿐이다
				String emp_id = rs.getString(1);//employee_id컬럼 인덱스를 사용함 오라클인덱스는1부터시작
				String f_name = rs.getString("first_name");//컬럼명을 지정하여 이용함
				String l_name = rs.getString(3);//last_name 컬럼
				java.sql.Date h_date = rs.getDate("hire_date");
				int sal = rs.getInt("salary");
				
				System.out.printf("%s %s %s %s %s \n",
						emp_id, f_name, l_name, h_date, sal);
			}
			/*
			6] 자원 반납 : 모든 작업을 마친 후에는 메모리 절약을 위해 연결했던 자원을 반납한다.
			 */
			rs.close();
			stmt.close();
			con.close();
		}
		else {
			System.out.println("연결실패");
		}
	}
}
