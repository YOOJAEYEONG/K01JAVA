package ex11static;

public class E02StaticBlockMain
{

	public static void main(String[] args)
	{

		System.out.println("static블럭 - 다른 클래스의 메인메소드");
		new StaticBlock();//메인메소드의 코드가 실행되다가 StaticBlock이 생성되면 static블럭이 실행됨
		System.out.println("StaticBlock.staticVar = " + StaticBlock.staticVar);
		
	}

}
