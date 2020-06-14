package ex21jdbc.shopping;

import ex21jdbc.connect.IConnectImpl;

public class InsertShop extends IConnectImpl{

	
	public InsertShop() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		//일련번호, 상품명, 상품가격, 등록일, 상품코드
		String str = ""
				+ " INSERT INTO sh_goods "
				+ " VALUES (goods_seq.NEXTVAL,?,?,sysdate,?) ";
		try {
			psmt = con.prepareStatement(str);
			psmt.setString(1, scanValue("상품명: "));
			psmt.setString(2, scanValue("상품가격: "));
			psmt.setString(3, scanValue("상품코드(1,2,3): "));
			
			int affected = psmt.executeUpdate();
			
			if(affected==0)
				System.out.println("상품입력 실패");
			else
				System.out.println("입력된 행의 갯수: "+affected);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public static void main(String[] args) {

		new InsertShop().execute();
	}

}
