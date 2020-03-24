package ex10Accessmodifier;

class FruitSeller{//과일판매자를 추상화한 클래스
	
//	외부클래스에서 접근할수 없도록 private으로 선언한다.
	private int numOfApple;//판매자의 사과 보유갯수
	private int myMoney;//판매자의 수익
	private final int APPLE_PRICE;//다시 상수로 선언함.

	


	public FruitSeller(int money, int appleNum, int price) {
		
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;//<=생성자 내에서는 상수를 초기화할수 있음.
	}
	
	
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	
	
	public void showSaleResult() {
		System.out.println("판매가]남은사과갯수:"+numOfApple);
		System.out.println("판매자]판매수익"+myMoney);
	}
}
//////////////////////////////////////////////////////////////////////

class FruitBuyer{
	
	private int myMoney;
	private int numOfApple;//구매한 사과의 갯수
	

	
	public FruitBuyer(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	
	public void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	
	public void showBuyResult() {
		System.out.println("구매자]현재잔액:"+myMoney);
		System.out.println("구매자]사과갯수"+numOfApple);
	}
}
///////////////////////////////////////////////////////////////////

public class E03InformationHinding {

	public static void main(String[] args) {
		
		

		
		//판매자1
		FruitSeller seller1 = new FruitSeller(0, 100, 1000);
		
		//판매자2
		FruitSeller seller2 = new FruitSeller(0, 80, 500);
		
		FruitBuyer buyer = new FruitBuyer(10000, 0);
		
		
		System.out.println("구매행위가 일어나기전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		
		/*
		 * 아래 {부터}까지 코드는 문법적으로는 오류가 없으나 지불금액과 
		 * 구매한 사과의 관계가 전혀 맞지 않는 논리적 오류가 발생되었다.
		 * 즉, 코드(메소드)로 구현한 규칙이 완전히 무너지게 된다.
		 * 객체지향 언어에서는 이런 논리적 오류를 범하지 않기위해
		 * "정보은닉" 이라는 개념을 제시하고 있다.
//		 */
//		{
			/*
			 * 멤버 변수를 private으로 선언하면 외부클래스에서는 접근이 불가능하므로
			 * 아래코드는 에러가 발생한다.
			 */
//			seller1.myMoney += 1000;//판매자1에게 1000을 지불하고
//			seller1.numOfApple -=50;//사과 50개를 얻었다.
//			buyer.numOfApple += 50;
//		
//		
//			seller2.myMoney += 1000; //판매자 2에게 1000원을 지불하고
//			seller2.numOfApple -= 70; //사과 70개를 얻었다.
//			buyer.numOfApple += 70;//하지만 구매자의 보유금액은 차감되지 않아 논리적으로 맞지않는 상황이 발생함.
//		}
//		▼수정 {}
		/*
		 * 판매자1,2에게 각각의 금액을 지불하고 금액에 해당하는 사과를 정상적으로 구매하였다.
		 * 정보은닉을 통해 판매의 규칙이 지켜지게 되었다.
		 */
		{
		buyer.buyApple(seller1, 1000);//buyApple()함수는 판매규칙을 잘 만들어놓았으므로 논리적인 문제가 발생하지 않는다.
		buyer.buyApple(seller2, 1000);
		}
		
		
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		
	}
}
