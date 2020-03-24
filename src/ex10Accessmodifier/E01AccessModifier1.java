package ex10Accessmodifier;

/*
 * class를 정의할때는 반드시 public 과 default(생략형)만 가능하다.
 * 아래에서는 에러 발생됨
 * 
private class Private Class1 {
	void myFunc() {
		System.out.println("나는 정의할수 없는 클래스");
	}
*/
	
/*
 * 접근지정자를 생략했으므로 default class로 지정된다.
 * 해당클래스는 동일 패키지 내에서만 접근 가능하다.
 */
class DefaultClass1 {
	void myFunc() {
		System.out.println("DefaultClass의 myFunc()호출");
	}
}

public class E01AccessModifier1
{
//	멤버변수를 각각 접근지정자를 통해 선언
	private int privateVar;
	int defaultVar;
	public int publicVar;
	
//	동일 클래스내에서는 private 멤버라 할지라도 접근이 가능.
//	즉, 같은 클래스라면 접근지정자의 영향을 받지 않는다.
	private void privateMethod() {
		privateVar = 100;
		System.out.println("privateMethod()호출");
	}
	
	
	void defaultMethod() {

		privateVar = 200;
		System.out.println("defaultMethod()호출");
	}
	
//	private으로 선언된 멤버(변수 또는 메소스)를 외부 클랠스에서
//	접근하고 싶을때는 public으로 선언된 멤버 메소드를 이용해서
//	간접적으로 접근을 허용한다.
	public void publicMethod() {
		privateVar = 300;// private으로 선언된 멤버 변수를 public메소드를 통해 간접적으로 접근했음.
		System.out.println("publicMethod()호출");
		privateMethod();
	}
}
