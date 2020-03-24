package ex18lambda;


/*
익명클래스로 오버라이딩 
 */
interface IKosmo2{
	//인터페이스에 정의된 메소드는 public abstract가 생략되어있는 추상메소드
	void studyLambda(String str);
}

public class Ex02AnonymousClass {

	public static void main(String[] args) {
		
		//IKosmo2인터페이스를 구현한 익명클래스 정의
		IKosmo2 kosmo = new IKosmo2() {
			@Override
			public void studyLambda(String str) {
				System.out.println(str+"을 공부하기위한 익명클래스를 만들었다.");
			}
		};
		kosmo.studyLambda("람다식");
	}
}
