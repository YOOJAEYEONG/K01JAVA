package ex05method;



/*
Method(메소드)
	: 객체지향 프로그램에서 행동 또는 동작을 의미한다.
	즉 어떤하나의 업무를 처리하는 모듈(부속품)이라 정의 할수 있다.
규칙
	-메소드는 반드시 class안에 정의 해야한다.
	-메소드 안에 다른 메소드를 정의할 수없다.
	-반환타입이 없더라도 반드시 void를 명시해야한다.
	-이름의 규칙은 변수명과 동일하다. (Ex: addCalculate())
 */
/*
Java에서 네이밍규칙
	-클래스명 : SimpleFunc		->대문자로 시작하는 Camel Case
	-메소드명 , 변수명 :	simpleFunc(), simpleFunc	
		-> 소문자로 시작하는 변형 camel Case
	-상수 : SIMPLE_FUNC	-> 전체를 대문자로 표현하고, 연결된 단어는 _를 사용함.
	 	Ctrl+Shift+ X or Y
	-패키지명 : simplefunc	->전체를 소문자로 표현한다.
		연결된 단어가 있더라도 언더바를 사용하지 않음. 
		_(언더바) 대신	.(닷)으로 표현한다.
 */
public class E02MethodType01 {

/*
메소드형식1] 매개변수와 반환값이 모두 없는 경우
	: 해당 형식은 주로 출력을 담당하는 기능으로 사용된다.
	반환타입은 반드시 void로 기술해야 한다.
 */
	static void noParamNoReturn() {
		System.out.println("======메뉴를 선택하세요======");
		System.out.println("1.열기	2.계속하기	3.종료");
		System.out.println("=========================");
	}
	
	static void noParamNoReturn2() {
//	경우에 따라 함수의 몸체가 없는 경우도 있음		
	}
	
	static void noParamNoReturn2(int a) {
//	동일한 이름의 함수가 선언되었음. 단, 매개변수의 갯수가 다름. ; 메소드오버로딩이라 한다.
	}
	
	static void noParamNoReturn3() {
		int returnValue = 89;
		System.out.println("[Return문 이전]");
		
//		return;
		/*
		위와 같이 함수 중간에 return을 쓰게 되면 함수가 종료되므로 아래문장은
		실행되지 않는 코드가 된다. 단, 함수의 마지막부분에 있는경우는 상관없다.
		*/
		
		if(returnValue%2==0) {
			System.out.println(returnValue + "는 짝수");
			return;
		}
		
		System.out.println(returnValue + "는 홀수");
		System.out.println("[Retern문 이후]");
	}
	
	public static void main(String[] args) {

		noParamNoReturn();
		noParamNoReturn2();
		noParamNoReturn3();
		
		
	}

}
