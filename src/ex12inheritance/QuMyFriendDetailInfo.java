package ex12inheritance;


class MyFriendInfo
{
	private String name;
	int age;
	
	public void ShowMyFriendInfo() {
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
	}
	
	public MyFriendInfo(String _name, int _age) {
		name = _name;
		age = _age;
	}
}
//친구의 기본정보 외 상세정보를 저장할 클래스
class MyFriendDetailInfo extends MyFriendInfo
{
	private String addr;
    	private String phone;

    	
	public void ShowMyFriendDetailInfo()
	{
		//부모클래스의 멤버메소드를 호출할때 명시적으로 super를 붙여주는 것이 좋다.(안붙여도 문제는 없지만)
		super.ShowMyFriendInfo();
		System.out.println("주소: "+ addr);
		System.out.println("전화: "+ phone);
	}
	public MyFriendDetailInfo(String _name, int _age, String _addr, String _phone) {
		
		super(_name, _age);
		addr = _addr;
		phone = _phone;
	}
}
class QuMyFriendDetailInfo
{
	public static void main(String[] args)
	{
		MyFriendDetailInfo info = new MyFriendDetailInfo("랩몬스터", 100, "빅히트", "010-4568-4656");
		info.ShowMyFriendDetailInfo();
		
		//이름, 나이, 주소, 전화번호를 인자로 객체를 생성…
		//정보Print
		
		//인자생성자
	}
}

