package ex21jdbc.shopping;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class DeleteShop extends IConnectImpl{

	public DeleteShop() {
		super("kosmo", "1234");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() {
		
		try {
			csmt = con.prepareCall("{call ShopDeleteGoods(?,?)}");
		
			csmt.setString(1, scanValue("삭제할 상품의 일련번호: "));
			csmt.registerOutParameter(2, Types.NUMERIC);
			csmt.execute();
			int affected = csmt.getInt(2);
			if(affected==0)
				System.out.println("오류발생:입력실패");
			else
				System.out.println(affected+"행 삭제 성공");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public static void main(String[] args) {

		new DeleteShop().execute();
	}

}
