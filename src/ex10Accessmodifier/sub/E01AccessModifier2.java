package ex10Accessmodifier.sub;

class DefaultClass2{
	void myfunc() {
		System.out.println("DefualtClass의 myFunc() 호출");
	}
}
public class E01AccessModifier2
{
	private int privateVar;
	int defaultVar;
	public int publicVar;
	
	private void privateMethod() {
		privateVar = 400;
		System.out.println("privateMethod()호출");
	}
	void defaultMethod() {
		privateVar = 500;
		System.out.println("defaultMethod()호출");
	}
	public void publicMethod() {
		privateVar = 600;
		System.out.println("publicMethod()호출");
		privateMethod();
	}
}
