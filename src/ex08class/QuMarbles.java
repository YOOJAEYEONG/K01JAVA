package ex08class;
/*
문제3) QuMarbles.java
구슬치기 하는 아이들을 추상화하여 클래스로 정의해보자.
*어린아이가 보유하고 있는 구슬의 개수 정보를 담는다
*놀이를 통해 구슬을 획득 또는 상실하는 것을 표현한다.
*어린이의 현재 보유하고 있는 구슬의 개수를 표현한다.
초기화는 다음과 같이 진행한다.
◆어린이1의 보유갯수 : 구슬 20개
◆어린이2의 보유갯수 : 구슬 15개
게임은 다음과 같이 진행한다.
◆1차게임 : 어린이1은 어린이2의 구슬 5개를 획득한다.
◆2차게임 : 어린이2는 어린이1의 구슬 9개를 획득한다.
# 어린이 객체를 생성시 구슬의 보유갯수는 생성자를 통해 초기화 되어야 한다.
 */


class ChildProperty {
	
	int beadCnt;//멤버변수:어린이가 보유한 구슬 수;
	
	
	/*
	 * ▼디폴트 생성자는 개발자가 생성자를 정의하지
		않았을때만 자동으로 생성된다.
	 */
	//public ChildProperty(){  }
	
	
	
	//생성자메소드: 멤버변수를 초기화 한다.
	public ChildProperty(int getBeads)//생성자 이름은 항상 클래스와 동일해야한다.
	{
		beadCnt = getBeads;
	}
	
	
	int earnBeads(int Beads) {
		beadCnt += Beads;
		return beadCnt;
	}
	

	public void obtainBead(ChildProperty child, int bCnt) {
		
//		게임에 승리한 어린이는 해당 메소드를 호출하는 주체, 즉 해당 객체가 된다.
		this.beadCnt += bCnt;
		System.out.println("this.beadCnt"+this.beadCnt);
		System.out.println("this.beadCnt"+beadCnt);
		System.out.println();
		System.out.println();
		System.out.println();
		//매개변수로 전달된 어린이 객체는 게임에 패배하여
//		구슬 bCnt만큼 차감해야함.
		child.beadCnt -= bCnt;
		System.out.println("child.beadCnt"+child.beadCnt);
		
	}
	
	public void showProperty() {
		System.out.println("보유 구슬의 개수"+beadCnt);
		
	}
	

	
}



public class QuMarbles
{

	public static void main(String[] args)
	{

		
		ChildProperty child1 = new ChildProperty(20);
		ChildProperty child2 = new ChildProperty(15);

		
		
		
		System.out.println("게임 전 구슬의 보유 개수");
		System.out.print("어린이1 : ");
		child1.showProperty(); 
		System.out.print("어린이2 : ");
		child2.showProperty(); 

		/*1차게임 : 어린이1은 어린이2의 구슬 5개 획득*/
		child1.obtainBead(child2, 5);

		/*2차게임 : 어린이2가 어린이1의 구슬 9개 획득*/
		child2.obtainBead(child1, 9);

		System.out.println("\n게임 후 구슬의 보유 개수");
		System.out.print("어린이1 : ");
		child1.showProperty(); 
		System.out.print("어린이2 : ");
		child2.showProperty();

	}
}

/*
게임 전 구슬의 보유 개수
어린이1 : 보유 구슬의 개수 20
어린이2 : 보유 구슬의 개수 15

게임 후 구슬의 보유 개수
어린이1 : 보유 구슬의 개수 16
어린이2 : 보유 구슬의 개수 19
*/
