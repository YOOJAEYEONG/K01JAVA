package ex12inheritance;

/*
 * [상속]IS-A관계
 * 	: X is A Y=> X는 Y의 일종이다로 표현가능
 * 	- 노트북은 컴퓨터의 일종이다
 *  - 휴대폰은 전화기의 일종이다
 *  이와같이 Is-A관계가 성립하는 개체를 상속으로 표현하기에 적합하다.
 */

/*
 * 컴퓨터를 표현
 * 	: 기본적인 컴퓨팅 환경을 제공하여 입력된 내용을 계산한다.
 */
class Computer{
	
	String owner;
	
	public Computer(String name) {
		owner = name;
	}
	
//	private 접근지정자로 선언된 멤버 메소드는 외부클래스 혹은
//	상속받은 클래스에서도 접근이 불가능하므로
//	public 으로 선언된 메소드를 통해서 간접 호출을 해야한다.
//	상속관계라면 protected로 선언된 메소드로 호출할 수 있다.
	private void keyboardTouch() {
		System.out.println("키보드를 통해서 입력한");
	}
	private void calculate() {
		System.out.println("요청된 내용을 계산한다.");
		
	}
	public void calculateFunc() {
		keyboardTouch();
		calculate();
	}
	/*
	 * 해당 메소드는 내부에서만 접근되므로 호출 순서를 지켜 실행 할 수 있도록 캡슐화하여 정의 하였다.
	 */
}



/*
 컴퓨터를 상속한 노트북컴퓨터
 	: 컴퓨터가 가지고 있는 기본기능에 휴대이용 부분을 확장하여
 		정의 하였음. 휴대이용을 위해 배터리 멤버변수가 추가됨.
 */
class NotebookComputer extends Computer{
	int battary;
	
	
//	부모생성자 호출을 위해 사용하는 super()는 생략은 가능하지만
//	앞에 다른문장이 먼저오게 되면 오류가 발생되므로 주의해야한다.
	public NotebookComputer(String name, int initCharge) {
		super(name);
		battary = initCharge;
	}
	
//	배터리충전을 표현
	public void charging() {
		battary += 5;
	}
	
//	휴대하면서 컴퓨팅을 할수 있는것을 표현
	public void movigcal() {
		//베터리양을 체크하여 사용여부 판단.
		if(battary < 1) {
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		System.out.println("이동하면서");
		
		
//		아래 메소드는 private로 선언되었으므로 
//		상속받은 자식 클래스에서도 접근은 불가능하다
//		keyboardTouch();
//		calculate();
		
		calculateFunc();
		battary--;
	}
	
}

/*
 * 태블릿 노트북 컴퓨터
 * 	: 컴퓨터의 기본기능, 휴대이용에 펜으로 드로잉 할 수 있는 기능까지
 * 	추가된 클래스
 */
class TabletNoteBook extends NotebookComputer{
	String registPencil;
	public TabletNoteBook(String name, int initCharge, String pen) {
		super(name, initCharge);
		
		registPencil = pen;
	}
	
//	태블릿 사용을 위해 배터리량 체크 및 등록된 펜인지 체크
	public void write(String penInfo) {
		if(battary < 1) {
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		/*
		A.compareTo(B)
			: 문자열 A와 B를 비교하여 0이 반환되면 같은 문자열
			서로 다른 문자열로 판단하면 -1 혹은 1이 반환한다. 
		*/
		if(registPencil.compareTo(penInfo) != 0) {
			System.out.println("등록된 펜이 아닙니다.");
			return;	
		}
		movigcal();
		System.out.println("스크린에 펜으로 그림을 그린다.");
		battary--;
	}
}
public class E04ISAInheritance {

	public static void main(String[] args) {
		
		NotebookComputer notebook = new NotebookComputer("공유", 5);
		TabletNoteBook tablet =
				new TabletNoteBook("이동욱", 5, "ISE-1234");
		
		System.out.println("====노트북컴퓨터사용====");
		notebook.movigcal();
		notebook.movigcal();
		notebook.movigcal();
		notebook.movigcal();
		notebook.movigcal();
		notebook.movigcal();
		notebook.movigcal();
		notebook.movigcal();
		
		System.out.println("===ISE-1234펜으로 테블릿 사용==");
		tablet.write("ISE-1234");
		
		System.out.println("===XYZ-9876 펜으로 테블릿 사용===");
		tablet.write("XYZ-9876");
		
	}
}


























