package ex09package;

import ex09package.kosmo.perimeter.Circle;

/*
 * 메인 클래스에서 다른 패키지의 클래스를 import하여 사용하려면 
 * 해당 클래스는 반드시 public으로 선언되어야 한다.
 * 그렇지 않으면 "not visible" 에러가 발생한다.
 */

public class CircleMain
{

	public static void main(String[] args)
	{

//		원의 넓이 : 클래스 사용을 위해 풀패키지 경로를 사용함.
		ex09package.kosmo.area.Circle circle1 = 
				new ex09package.kosmo.area.Circle(6.5);
		System.out.println("반지름이 6.5인 원의 넓이:"+ circle1.getArea());
		
		
		
		
		//ex09package.kosmo.perimeter.Circle circle2 = new ex09package.kosmo.perimeter.Circle(4.5);
//		▲ import를 안했을 경우 아래 생성및 초기화 대신 이렇게 해도 된다. 그러나 이런방법은 불편하기때문에 import를 이용하고
//		다른 패키지인데 같은 클래스명을 불러 와야 할때 사용하는것이다.
		
//		원의 둘레 : import하여 해당 클래스를 문서에 포함시킴
		Circle circle2 = new Circle(4.5);
		System.out.println("반지름이 4.5dls 원의 둘레:" + circle2.getPerimeter());
	}

}
