package ex20io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;


/*
연습문제] 해당프로그램은 친구의 정보를 저장하게 된다.
프로그램 종료시 Friend타입의 객체 배열에 저장된 친구의 정보를 
파일의 형태로 저장할 수 있도록 직렬화 하시오.
-저장될 파일명 : friend_info.obj
 */
class Friend implements Serializable{//부모클래스에서 직렬화를 했기때문에 자식 객체들은 같이 상속받는다
	String name;
	String phone; //전화번호
	String addr;
	
	public Friend (String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	
//	[멤버메소드]	멤버변수 전체 정보를 출력하는 메소드
	public void showAllData() {
		System.out.println("name: " + name);
		System.out.println("phoneNumber : "+ phone);
		System.out.println("addr : " + addr);
	}
//	간략한 정보만을 출력하는 메소드로 , 현재 실행부가 없는 상태로 정의되었다.
//	여기서는 오버라이딩을 할 목적으로 정의 되었다.
	public void showBasicInfo() { }
}

class HighFriend extends Friend	{
	String nickname;// 자식에서 확장한 멤버변수

	public HighFriend(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	
//	고딩친구의 전체정보 출력을 위해 부모에서 정의된 메소드를 super를 통해 호출하고,
//	자식에서 확장한 변수를 별도의 print문을 통해 출력하고있다.
	@Override
	public void showAllData() {
		System.out.println("======HighFreind(AllDate)=========");
		super.showAllData();
		System.out.println("nickname : " + nickname);
	}
	
//	자식에서 오버라이딩하여 재정의한 메소드로 고딩친구의 간략한 정보를 출력한다
	@Override
	public void showBasicInfo() {
		System.out.println("====HighFriend===");
		System.out.println("nickname : " + nickname);
		System.out.println("phoneNumber : " + phone);
		
	}
}

class UnivFriend extends Friend {
	
	String major;

	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}
	

	
	@Override
	public void showAllData() {
		System.out.println("===UnivFriend(AllDataInfo=====");
		super.showAllData();
		System.out.println("major : "+ major);
		
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("====UnivFriend====");
		System.out.println("name : "+ name);
		System.out.println("phoneNumber : " + phone);
		
	}
	
	
}


public class E13MyFriendSerializable_review {

//	프로그램에서의 입력메뉴 출력
	public static void menuShow() {
		
		System.out.println("***메뉴를 선택하세요***");
		System.out.println("1.고딩친구입력");
		System.out.println("2.대딩친구입력");
		System.out.println("3.전체정보출력");
		System.out.println("4.간략정보출력");
		System.out.println("5.검색");
		System.out.println("6.삭제");
		System.out.println("7.프로그램종료");
		System.out.println("8.메뉴선택>>>");
	}
	
	public static void main(String[] args) {

//		프로그램 전반에 대한 비즈니스로직을 가진 핸들러 객체 생성
		FriendInfoHandler handler = new FriendInfoHandler(100);
		
		while(true) {
			//메뉴출력을 위한 메소드 호출
			
			menuShow();
			
			Scanner scan = new Scanner(System.in); 
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1: case 2:
				handler.addFriend(choice);
				break;
			case 3:
				//전체정보출력
				handler.showAllData();
				break;
			case 4:
				//간략정보출력
				handler.showSimpleData();
				break;
			case 5: 
				//친구정보검색
				handler.searchInfo();
				break;
			case 6:
				//친구정보삭제
				handler.deleteInfo();
				break;
			case 7:
					//힌트
					handler.saveFriendInfo();
					System.out.println("프로그램을 종료합니다.");
					return;//메인 함수의 종료는 프로그램 종료로 이어진다.
				
					
			}
		}// end of while
	}// end of main
	


}//end of class

class FriendInfoHandler{
	
/*	[멤버변수]
	Friend타입의 객체배열은 하위클래스인 High, Univ객체를 모두 저장할 수 있으므로
	하나의 배열내에 2개의 객체를 동시에 저장하여 관리 할 수 있다.
*/
	
	private Friend[] myFreinds;
	private int numOfFriends;//친구의 정보를 추가할 때마다 +1
	
//	생성자 : 인자로 전달되는 num크기로 객체배열을 생성한다.
	public FriendInfoHandler(int num) {
		myFreinds = new Friend[num];
		numOfFriends = 0;
	}
	
	public void addFriend(int choice) {
		
//		사용자로부터 친구정보를 입력받기 위한 준비
		Scanner scan = new Scanner(System.in);
		String iName, iPhone, iAddr, iNickname, iMajor;
		
//		공통사항 입력받기
		System.out.println("이름 : "); iName = scan.nextLine();
		System.out.println("전화번호 : "); iPhone = scan.nextLine();
		System.out.println("주소 : "); iAddr = scan.nextLine();

		/*
		1. 친구정보 입력받은 후
		2. 객체배열 0번방에 객체를 저장
		3. numOfFriends 변수를 +1 증가시킨다.(후위증가)
		 */
		if(choice==1) {
			//고딩친구 입력
			System.out.println("별명 : "); iNickname = scan.nextLine();
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			myFreinds[numOfFriends++] = high;
		}
		else if(choice==2) {
			//대딩친구입력
			System.out.println("전공 : "); iMajor = scan.nextLine();
			myFreinds[numOfFriends++] = new UnivFriend(iName, iPhone, iAddr, iMajor);
		}
	}//end of addFriend
	
	//친구정보 전체보기
	public void showAllData() {
		for(int i = 0; i < numOfFriends; i++) {
			myFreinds[i].showAllData();
		}
		System.out.println("====전체정보가 출력되었습니다.====");
	}
	
	/*
	1. 고딩친구 정보를 Friend 추가
	2. High 객체가 Friend타입으로 자동형변환되어 저장
	3. 객체배열에 저장된 객체들을 for문을 통해 순차적으로 출력
		이때 오버라이딩된 메소드를 통해 항상 해당 객체의 정보를 출력할 수 있음.
		(오버라이딩은 참조변수의 타입에 상관없이 항상 마지막 하위 클래스의 메소드를 호출)
	 */
	//친구정보 간략보기
	public void showSimpleData() {
		for(int i=0; i<numOfFriends ; i++) {
			myFreinds[i].showBasicInfo();
		}
		System.out.println("====간략정보가 출력되었습니다.====");
	}
	
	//주소록 검색
	public void searchInfo() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요.");
		String searchName = scan.nextLine();
		
		for(int i=0; i<numOfFriends ; i++) {
			
			System.out.println("검색중인 이름 : "+ myFreinds[i].name);//제대로 작동하는지 확인하는줄
			
//			검색할 이름과 객체의 이름이 일치하는경우 모든정보를 출력함
			if(searchName.compareTo(myFreinds[i].name)==0) {
				myFreinds[i].showAllData();
				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
			}
		}
		
	}
	
	//주소록 항목 삭제
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하시요 : ");
		String deleteName = scan.nextLine();
		
//		배열의 요소중 삭제된 요소의 인덱스 값을 저장할 용도의 변수
//		요소를 삭제한 후 빈자리를 채울때 사용할 예정임.
		int deleteIndex = -1;
		
		for(int i=0; i<numOfFriends; i++) {
			if(deleteName.compareTo(myFreinds[i].name)==0) {
//				요소를 삭제하기위해 참조값을 null로 변경
				myFreinds[i] = null;
//				삭제된 요소의 인덱스값 저장
				deleteIndex = i;
//				전체카운트 변수 -1차감
				numOfFriends--;
			}
		}
		
		if(deleteIndex == -1) {
//			검색된 데이터가 없는경우
			System.out.println("===삭제된 데이터가 없습니다.====");
			
		}
		else {
//			객체배열에서 검색된 요소를 삭제한 후 입력된 위치의 바로 뒤 요소를 앞으로 하나씩 당긴다.
			for(int i=deleteIndex ; i< numOfFriends ; i++) {
				myFreinds[i] = myFreinds[i+1];
			}
			System.out.println("==데이터(" + deleteIndex + "번)가 삭제되었습니다.");
		}
	}///deleteInfo
	
	//친구의 정보를 파일로 저장
	public void saveFriendInfo() {
		
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(
							new FileOutputStream("src/ex20io/friend_info.obj"));
			
			//myFriends 객체 배열에 저장된 친구의 정보만큼 반복
			for(int i=0; i<numOfFriends ; i++) {
				//객체배열의 i번째 요소를 파일로 저장
				out.writeObject(myFreinds[i]);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
		
	}
	
}//FriendInfoHandler





























