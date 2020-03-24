package quiz_game;

import java.util.Random;
import java.util.Scanner;

/*
게임설명 : 업다운게임을 메소드를 이용해 구현한다.
컴퓨터는 1~100사이의 숫자 하나를 생성한다.
총 시도횟수는 7번을 부여한다.
사용자는 7번의 시도안에 숫자를 맞춰야 한다.
사용자가 숫자를 입력했을때 컴퓨터는 높은지/낮은지 알려준다.
7번안에 맞추면 성공, 맞추지 못하면 실패라고 출력한다.
성공/실패 후 계속 할지를 물어보고 1이면 게임 재시작, 0이면 프로그램을 종료한다.
함수를 사용하여 구현한다.
무한루프에 빠지게 된다면 scan.nextLine()을 활용하여 버퍼에 남아있는 Enter키를 제거해주도록 하자.

 */
public class QuUpDownGame {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int inputNumber;
		int randomNumber;
		int life=7 ;

		System.out.println("▩▩업&다운게임▩▩");
		randomNumber = (int)(Math.random()*100+1);	

		for(boolean gameOnOff = true ; gameOnOff ; ) {
			System.out.println("시작합니다\n1~100사이의 수를 입력하세요");
			for( ; life>0; life--) {
				inputNumber = sc.nextInt();
				
				if(inputNumber < randomNumber ) {
					System.out.println("up!!");
				}
				else if(inputNumber > randomNumber) {
					System.out.println("down!!");
				}
				else if(inputNumber == randomNumber) {
					System.out.println("성공!! ");
					break;
				}
				
			}
			gameOnOff = selectGame();
			if(gameOnOff)
				life = 7;
		}
	}
	public static boolean selectGame() {

		System.out.println("7번의 기회를 다썼습니다.");
		System.out.println("다시도전하겠습니까?");
		System.out.println("1:재시작\t0:종료");
		
		switch (sc.nextInt()) {
		
			case 1: 
				return true ; 
			case 0:
				return false;
			default : return true;
		}
	}
}




