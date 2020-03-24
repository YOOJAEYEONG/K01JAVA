package quiz_game;

import java.util.Scanner;

/*
게임설명 : 야구게임을 메소드를 이용하여 구현한다.
중복되지 않는 3개의 정수를 생성한다.(1~9)
사용자는 3개의 숫자를 입력한다.
생성된 3개의 숫자를 맞추는데 위치까지 정확히 맞춰야 한다.
숫자와 숫자의 위치까지 일치하면 strike 로 판정한다.
숫자는 맞지만 위치가 틀렸다면 ball 로 판정한다.
숫자3개가 모두 일치하지 않으면  out 으로 판정한다.
3 strike 가 되면 게임은 종료된다.
시도한 횟수를 표시한다.
계속할지 종료할지 여부를 물어보고 다음 진행을 한다.

위 문제의 변수들을 배열을 이용하여 구현해본다.
   int com1, com2, com3; -> int[] com = new int[3];
   int user1, user2, user3; -> int[] user = new int[3]; 
3개의 난수를 생성하는 부분과 스트라이크, 볼을 판정하는 부분은 배열을 이용한 로직으로 변경해야 한다.

 */
public class QuBaseballGame {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int strike;
		int ball;
		int out;
		int cnt_Strike_Ball;
		int gameSet	= 0;
		boolean gameReset = true;
		ArraySet arrayUser	= new ArraySet();
		ArraySet arrayCom	= new ArraySet();
		

		
		System.out.println("=========야구게임=========");
		arrayCom.setterCom();
		do {
			strike = 0;
			ball = 0;
			out = 0;
			
			System.out.println("1~9사이의 숫자를 입력하세요.");
			arrayUser.setterUser();
			
			for(int a=0 ; a < ArraySet.com.length; a++) {
				cnt_Strike_Ball=0;
				for(int b=0 ; b < ArraySet.com.length; b++) {
					if(ArraySet.com[a]==ArraySet.user[b]) {//만약 값이 같으면
						if(a==b	) {//만약 인덱스 순서도 같으면 스트라이크
							strike++;
							cnt_Strike_Ball++;
						}
						else {//ball
							ball++;
							cnt_Strike_Ball++;
						}
					}
				}
				//앞서 판단했던 조건중 strike나 ball이 해당하지않아 값이 0인경우 아웃으로 처리
				if(cnt_Strike_Ball==0) { out++; }
			}
			
			System.out.printf("%d 스트라이크\t%d 볼\t%d 아웃\n", strike, ball, out);
			
			if(strike==3) {
				System.out.println("3스트라이크로 게임이 끝났습니다.\n재시작은 아무숫자를, 종료는 0을 입력하세요.");
				if(sc.nextInt()==0) {//종료를 원할경우
					gameReset = false;
				}
				else {
					System.out.println("게임을 재시작 합니다.");
					arrayCom.setterCom();
				}
			}
			else {
				System.out.println(++gameSet+"번째 시도입니다.");
			}
		}while(gameReset);
	}
	
}

class ArraySet{
	
	static int[] user	= new int[3];
	static int[] com	= new int[3];
	
	public void setterUser() {
		
		for(int a=0 ; a < user.length ; a++) {
			user[a] = new Scanner(System.in).nextInt();
		}
	}
	
	public void setterCom() {
		for(int a=0 ; a < com.length ; a++) {
			com[a] = (int)(Math.random()*10)%9+1;
		}
		if( com[0]==com[1] || com[0]==com[2] || com[1]==com[2]) {
			//만약 중복되는 정수가 생성되면 재귀함수를 통한 com[]값을 다시 대입
			setterCom();
		}
		else {
			System.out.println("힌트:"+com[0]+"  "+com[1]+"  "+com[2]);
			return;//아님말고
		}
		
	}
	
}

