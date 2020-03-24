package ex09package.kosmo.buyer;

//FruitSeller4클래스는 외부 패키지에 정의되어있으므로
//반드시 import 해야한다. buyApple()메소드에서 매개변수로 사용하기 때문
import ex09package.kosmo.seller.FruitSeller4;

public class FruitBuyer4{
	
	int myMoney;
	int numOfApple;//구매한 사과의 갯수
	

	
	public FruitBuyer4(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	
	public void buyApple(FruitSeller4 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	
	public void showBuyResult() {
		System.out.println("구매자]현재잔액:"+myMoney);
		System.out.println("구매자]사과갯수"+numOfApple);
	}
}