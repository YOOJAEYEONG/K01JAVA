package ex08class;

class Triangle{
	/*
	float base,height;
	
	void init(int baseVal, int heightVal) {
		
		base = baseVal;
		height = heightVal;
	}
	
	void setBottom(int b) {	base = b;	}
	void setHeight(int h) {	height = h;	}
	float getArea() {	return (base*height)/2;	}
	*/
	
	//샘이 코딩한것
	
	int bottom, height;
	
	
	//밑변과 높이를 초기화하는 메소드
	public void init(int bot, int hei) {
		//멤버변수
		bottom = bot;//밑변
		height = hei;//높이
	}
	
	public double getArea() {
		return bottom*height*0.5;
	}
	
	
	public void setBottom(int bottom)
	{
		this.bottom = bottom;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
	
	
	
	
	
	
	
}
/*
밑변과 높이 정보를 저장할 수 있는 Triangle클래스를 정의해보자.
init메소드를 통해 밑변과 높이를 초기화한다.
그리고 밑변과 높이를 변경시킬수 있는 메소드와 삼각형의 넓이를 계산해서
반환하는 메소드도 함께 정의해보자.

 */
public class QuTriangle
{
	public static void main(String[] args)
	{
		Triangle t = new Triangle();
		t.init(10, 17); //밑변10, 높이17로 초기화=>멤버변수가 필요한것이다.
		System.out.println("삼각형의 넓이 : " + t.getArea());
		t.setBottom(50);//밑변 50으로 변경
		t.setHeight(14);//높이 14로 변경
		System.out.println("삼각형의 넓이 : " + t.getArea());
	}
}
