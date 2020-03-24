package ex03operator;

public class E03BeekyoOperator {

	/*
	비교연산자
		: 좌우측항의 값이 크거나, 같은지 비교하는 연산자
	 */
	public static void main(String[] args) {

		int num1 = 10, num2 = 20;
		
		//num1이 클때 참을 반환하므로, 거짓이되고 else문이 실행됨.
		if(num1 > num2) {
			System.out.println("num1이 더큽니다.");
		}
		else {
			System.out.println("num2가 더큽니다.");
		}
		
		//좌우항이 다르면 참을 반환하므로, 아래조건은 참이된다. if문 실행됨.
		if(num1 != num2) {
			System.out.println("num1과 num2는 다르다.");
		}
		else {
			System.out.println("num1과 num2는 같다.");
		}
			
	}

}
