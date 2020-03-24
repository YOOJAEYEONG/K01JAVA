package ex13E01interface;

/*
인터페이스(Interface)
-클래스가 객체의 설계도라면 인터페이스는 클래스의 설계도라 할수 있다.
-자바는 단일 상속을 원칙으로 하나 인터페이스를 통해 다중 상속을 구현할 수 있다.
-추상클래스와 동일하게 상속을 목적으로 제작되므로 구현받은 하위클래스에서
	반드시 오버라이딩 해야한다.
-멤버로는 추상메소드와 상수로만 구성된다.
	메소드->public abstract
	변수->public static final
-인터페이스는 생성자가 없다.
 */
interface MyInterface1{
//	생성자는 사용불가하다
//	public Myinterface1() {}
	
//	멤버상수
	public static final int MAX_INT = Integer.MAX_VALUE;
	double MAX_DBL = Double.MAX_VALUE;
	
	//멤버추상메소드
	public abstract void absFunc1();
	void absFunc2();
	void mySample();
	
}
/////////////////////////////////////////////////
interface MyInterface2{
	void absFunc2();
}
class SampleClass{
	int sample = 1;
	void mySample() {
		System.out.println("sample = " + sample);
	}
}
//////////////////////////////////////////////////

/*
인터페이스의 다중 구현
컴파를 이용해서 여러개의 인터페이스를 '구현'하는 거시 가능하다.
그리고 '상속'과 '구현'을 동시에 할 수도 있다.
 */
class MyClass extends SampleClass implements MyInterface1, MyInterface2{
	
	@Override
	public void absFunc1() {
		System.out.println("absFunc1이 호출됨");
	}
	
//	인터페이스에 동일한 이름의 추상메소드가 존재하는경우
//	하나만 오버라이딩 하면된다.
	@Override
	public void absFunc2() {
		System.out.println("absFunc2이 호출됨");
	}
	
	@Override
	public void mySample() {
		System.out.println("상속받은 sampleClass");
	}
}

public class E03InterfaceBasic {

	public static void main(String[] args) {
		
		MyInterface1 my1 = new MyClass();
		my1.absFunc1();
		my1.absFunc2();
		my1.mySample();
	}
	 
}
