package ex21jdbc.shopping;

import java.sql.PreparedStatement;

import ex21jdbc.connect.IConnectImpl;

public class SelectShop extends IConnectImpl{

	public SelectShop() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		//일련번호, 상품명, 상품가격, 등록일, 상품코드
		String str = ""
				+ " SELECT "
				+ "		g_idx, goods_name, "
				+ "		to_char(goods_price,'999,999,000'), "
				+ "		to_char(regidate,'yyyy-mm-dd hh:mi'), "
				+ "		p_code "
				+ " FROM sh_goods "
				+ " WHERE goods_name LIKE '%"+scanValue("상품명: ")+"%' ";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(str);
			
			if(rs.next()) {
				int g_idx = rs.getInt(1);
				String goods_name = rs.getString(2);
				String goods_price = rs.getString(3);
				String regidate = rs.getString(4);
				int p_code = rs.getInt(5);
				System.out.println("검색결과:");
				System.out.println("============================");
				System.out.println("일련번호: "+g_idx);
				System.out.println("상품명: "+goods_name);
				System.out.println("상품가격: "+goods_price);
				System.out.println("등록일: "+regidate);
				System.out.println("상품코드: "+p_code);
				System.out.println("============================");
			}
			else {
				System.out.println("검색된 상품이 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public static void main(String[] args) {

		new SelectShop().execute();
	}

}
