package ex09package.kosmo.area;

public class Circle
{
	double rad;
	final double PI;
//	일반적으로 상수형 변수는 한번만 초기화 할수 있기 때문에
//	생성과 동시에 초기화 해야하지만, 아래 같이 한번만 초기화하는
//	생성자의 경우 상수형 변수 선언후 생성자 안에서 초기화가 가능하다.
	
	public Circle(double rad) {
		this.rad = rad;
		PI = 3.14159;
	}
	//원의 넓이를 반환하는 멤버메소드
	public double getArea() {
		return PI*rad*rad;
	}
}
