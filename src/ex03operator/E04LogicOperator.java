package ex03operator;

public class E04LogicOperator {

	/*
	 * 논리연산자
	 * 	&& : 논리And. 양쪽 모두가 true일때만 true를 반환하고
	 * 		나머지는 false를 반환한다.
	 * 	|| : 논리 Or. 한쪽이 true이면 true를 반환하고,
	 * 		양쪽모두 false일때 false를 반환한다.
	 * 	! : 논리 Not. 반대의 논리를 반환한다.
	 */
	public static void main(String[] args) {

		int num1 = 10, num2 = 20;
		
		boolean result1 = (num1==100 && num2==20); //f And t => f
		boolean result2 = (num1<12 || num2>=30);//t Or f => t
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		
		//num1과 num2가 다를때 true를 반환한다. => if문 실행.
		if(!(num1==num2)) {
			System.out.println("num1 과 num2는 다르다.");
		}
		else {
			System.out.println("num1 과 num2는 같다.");
		}
		
	}

}
