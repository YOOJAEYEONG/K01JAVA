package ex08class;

public class E02HumanMain {

	/*
	 * 해당 예제에서는 Human클래스를 외부파일로 선언하였다.
	 * 동일한 패키지에 정의 된다면 컴파일러는 해당 클래스를 찾아서 즉시 객체(인스턴스)화 
	 * 할수있다. 
	 * 만약 다른 패키지에 선언된 클래스라면 반드시 import선언을 해줘야한다.
	 */
	
	
	public static void main(String[] args) {

//		1.객체생성
		Human human = new Human();
		
//		2.객체의 초기화
		human.name = "마이클";
		human.age = 28;
		human.energy = 4;
		
//		3.멤버메소드를 통해 상태 등의 행동을 구현함
		human.showState();
		human.eat();
		human.walk();
		human.thinging();
		human.showState();//3
		
//		4.에너지를 고갈시켜보기
		for(int i =  1; i<=7 ; i++) {
			human.walk();
		}
		
//		5.에너지를 계속 채워보기
		human.showState();
		for(int i = 1; i<=7 ; i++) {
			human.eat();
		}
		human.showState();
	}

}
