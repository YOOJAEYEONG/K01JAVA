package ex17collection;



class Apple{
	int weight;
	public Apple(int w) {
		this.weight = w;
	}
	public void showInfo() {
		System.out.println("사과의 무게는 "+weight+" 입니다");
	}
}

class Bananer{
	int sugar;
	public Bananer(int s) {
		this.sugar = s;
	}
	public void showInfo() {
		System.out.println("바나나의 당도는 "+sugar+" 입니다");
	}
}

/*
class FruitBox{
	Object item;
	public void store(Object item) {
		this.item = item;
	}
	public Object pullOut() {
		return item;
	}
}
=>기본 Object 기반의 FruitBox를 아래와 같이 제네릭 클래스로 정의한다.
자료형에 해당하는 부분을 대표문자T(type:객체의 자료형)으로 교체하고, 객체 생성시 
자료형을 결정하기위해 "클래스명<customType>" 형태로 변경한다.

 */
class GenericFruitBox<CustomType>{
	CustomType item;
	public void store(CustomType item) {
		this.item = item;
	}
	public CustomType pullOut() {
		return item;
	}
}

public class Ex02GenericClass {

	public static void main(String[] args) {
		
		/*
		인스턴스 생성시 customType부분을 결정하므로 구현의 편의성이 보장된다.
		각각 Apple, Bananer 객체를 저장할 수 있는 인스턴스가 생성됨.
		 */
		GenericFruitBox<Apple> appleBox = new GenericFruitBox<Apple>();
		appleBox.store(new Apple(10));
		Apple apple = appleBox.pullOut();
		apple.showInfo();//사과 무게 : 10
		
		GenericFruitBox<Bananer> bananerBox = new GenericFruitBox<Bananer>();
		bananerBox.store(new Bananer(20));
		Bananer Bananer = bananerBox.pullOut();
		Bananer.showInfo();//바나나의 당도 : 20
		
		/*
		1번예제에 오렌지 클래스가 있기 때문에 같은패키지이므로 문제 없이 사용이 가능한것
		OrangeBox는 인스턴스 생성시 Orange를 저장할 수 있는 용도로 생성되었기때문에
		다른 객체는 저장할 수 없다.
		아래코드에서 컴파일에러가 발생되므로 자료형에도 안전한	코드가 된다.
		 */
		GenericFruitBox<Orange> orangeBox = new GenericFruitBox<Orange>();
//		orangeBox.store("나는 오렌지"); <=컴파일 오류 발생
//		orangeBox.store(apple);
//		orangeBox.store(Bananer);
	}
}










