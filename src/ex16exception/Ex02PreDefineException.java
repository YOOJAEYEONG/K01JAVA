package ex16exception;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


/*
2] Run Time Error
- 컴파일시에는 체크가 안되고 실행시에만 발생되는 에러
- RuntimeException 클래스 계열로
  NullPointerException이 대표적인 하위 클래스이다.
- main메소드에서 무시하기 위해 throw 하더라도 오류가 발생되므로
	반드시 예외처리를 해줘야한다.
- 예외 발생시 JVM은 해당 에외클래스를 인스턴스화해서 프로그램쪽으로 전달하게 되고
	try-catch에서 받은 후 처리한다.
 */
public class Ex02PreDefineException {

	//참조변수 선언만하고 객체 생성은 되지 않은 상태
	static Date toDay;//=null값인 상태이다.
	
	public static void main(String[] args) {
		
		/*
		1] ArrayIndexOutOfBoundsException
		: 배열의 크기를 벗어난 인덱스를 사용할때 발생되는 예외이다.
		 */
		System.out.println("===ArrayIndexOutOfBoundsException===");
		
		int[] intArr = new int[2];
		try {
			intArr[0] = 100;
			System.out.println("0번방은:"+intArr[0]);
			intArr[1] = 200;
			System.out.println("1번방은:"+intArr[1]);
			
			intArr[2] = 300;/*
				예외가 발생하는 지점으로 , 예외 객체가 던져지므로 아래문장은
				실행되지 않음. catch블럭으로 바로 넘어감.
			*/
			System.out.println("앗~이방은?"+intArr[2]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외가 발생했어요");
			/*
			getMessage(): 예외에 대한 간략한 메시지만 표시함
			printStackTrace() : 예외가 발생할때의 에러메시지를 그대로 
				콘솔에 표시해줌. 개발시 훨씬 더 사용빈도 높음.
			 */
			System.out.println("예외메시지:"+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("0번방 재출력:"+intArr[0]);
		System.out.println("==ArrayIndexOutOfBoundsException발생후==");
		
		
		/*
		2] NumberFormatException
			: 숫자형식의 문자열을 int로 변환하는경우 해당 문자열이 숫자형식이 
			아니면 발생되는 예외
		 */
		System.out.println("### NumberFormatException ###");
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("나이를 입력하세요");
			String strAge = sc.nextLine();//<= "10살" 형태로 입력하면 
			int ageAfter10 = Integer.parseInt(strAge) + 10;//예외발생
			System.out.println("당신의 10년후 나이는 :"+ ageAfter10);
		}
		catch (Exception e) {
			System.out.println("나이는 숫자로만 입력해야합니다.");
			System.out.println("예외메시지:"+e.getMessage());
			e.printStackTrace();
		}
		
		
		
		/*
		3] InputMismatchException
			: 숫자를 입력해야하는 데 문자를 입력한 경우 발생되는 예외
		 */
		System.out.println("### InputMismatchException ###");
		try {
			System.out.println("나이를 입력하세요");
			int intAge = sc.nextInt();//<= 문자를 입력하면 예외 발생
			int ageAfter10 = intAge + 10;
			System.out.println("당신의 10년후 나이는 :"+ ageAfter10);
			
		}
		catch (InputMismatchException e) {
			System.out.println("나이는 문자형태로 입력하면 안되요.");
			System.out.println("예외메시지:"+e.getMessage());
			e.printStackTrace();
		
		}
		/*
		4] NullPointerException
			: 인스턴스 변수에 참조값이 없는 상태에서 호출하면 발생되는예외.
			즉 참조변수만 생성되고, 참조할 객체가 없는 상태에서 사용했을때 발생하게 된다.
		 */
		System.out.println("### NullPointerException ###");
		System.out.println("toDay="+ toDay);/*
			toDay 참조변수가 가지고 있는 null값을 
			toString() 메소드를 통해 String형태로 변환되어 출력된다.
			그래서 예외는 발생하지 않았다. */
		try {
			/*
			참조변수가 참조할 객체가 없는 상태이므로 해당 메소드를 호출할
			 수 없어 예외가 발생한다.
			 */
			System.out.println(toDay.getTime());
		}
		catch (NullPointerException e) {
			System.out.println("toDay 참조변수는 null입니다.");
			System.out.println("예외메시지: " + e.getMessage());
		}	
		
		
		/*
		5] ArithmeticException
			: 수학적 계산이 불가능한 경우 발생되는 예외
		 */
		System.out.println("### ArithmeticException ###");
		int result = 0;
		try {
			result = 10;
			System.out.println("결과는:"+ result);
		}
		catch (ArithmeticException e) {
			System.out.println("0으로 나눌수 없습니다.");
			System.out.println("예외메시지:"+ e.getMessage());
		}
		
		
		
		System.out.println("== ClassCastException ==");
		/*
		5] ClassCastException
			: 객체의 형변환이 불가능한 경우
		 */
		
		Object object = new Object();
		String strTest = new String();
		//////////////////////
//		if(strTest instanceof object) {
//			System.out.println("참");
//		}
//		else {
//			System.out.println("거짓");
//		}
		
		
		////////////////////
		try {
			String strObject = (String)object;
			/*
			왜 형변환이 안될까?
			Object 객체 입장에서 보면 모든 클래스에 상속될수 있지만 현재
			String 클래스와의 상속관계 여부가 없기 때문에. 
			 */
			
			
			
		} catch (ClassCastException e) {
			System.out.println("형변환 할 수 없습니다.");
			System.out.println(e);
			System.out.println(e.getMessage());
			e.printStackTrace();//<-개발시 가장 많이 사용함
			
		}
		System.out.println("==ClassCastException발생후==");
		
////////////////////////////////////////////////////////
	
		String str = "형변환되나요?";
		boolean castFlag = myClassCast(str);
		if(castFlag==true) {
			System.out.println("됩니다용.");
		}
		else{
			System.out.println("안됩니다용");
		}
		/*
			String 객체가 매개변수로 전달되면서 Object로
			(업캐스팅)형변환되기 때문에
			여기서는 상속관계가 확인되어 다운캐스팅이 가능하다.
		 */
	}
	public static boolean myClassCast(Object str) {		
		if(str instanceof String){
			return true;
		}
		else{
			return false;
		}
	}//myClassCast
}


















