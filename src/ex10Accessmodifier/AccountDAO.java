package ex10Accessmodifier;
//02-21-DAO&DTO

/*
 * DAO (Data Access Object)
 * 	: 데이터베이스의 data접근을 위한 객체이다.
 * 	주로 DB접근을 하기위한 로직과 비즈니스로직을 분리하기위해 사용한다.
 * 	MVC패턴에서는  M(Model)에 해당한다.V(front-end, html같은것들), C(controler)
 * 
 * 	해당 예제에서는 DB접속을 위한 목적은 아니고 DTO클래스에
 * 	저장된 데이터를 가공/처리하는 로직을 구현하기위한 목적으로 제작됨.
 */
public class AccountDAO
{

	private AccountDTO capsule = new AccountDTO();
	
	
	//멤버 메소드
	
	
	//초기화
	public void init(String name, String accNumber, int balance) {
		capsule.setName(name);
		capsule.setAccountNumber(accNumber);
		capsule.setBalance(balance);
	}

	public void deposit(int money) {//데이터를 가공/처리:입금
		capsule.setBalance(capsule.getBalance() + money);
		System.out.println(money+"원이 입금되었습니다.");
		printAccount();
	}
	
	public void withdraw(int money) {//데이터를 가공/처리:출금
		if(capsule.getBalance() < money) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		capsule.setBalance(capsule.getBalance() - money);
		System.out.println(money + "원이 출금되었습니다.");
		printAccount();
	}
	public void printAccount() {//통장 정보출력
		System.out.printf("[%s님의 계좌 정보]\n", capsule.getName());
		System.out.printf("계좌 번호:%s\n", capsule.getAccountNumber());
		System.out.printf("잔액 : %d \n", capsule.getBalance());
	}
}















