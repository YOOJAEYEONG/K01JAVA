package quiz_game;

import java.io.IOException;
import java.util.Scanner;

/*
문제) QuRockPaperScissors.java
게임설명 : 가위바위보 게임을 메소드를 통해 구현한다.
난수생성기를 이용하여 1, 2, 3중 하나의 숫자를 생성한다.
사용자가 가위(1),바위(2),보(3) 중 하나를 낸다.
승부를 판단하여 출력한다.
1,2,3 이외의 숫자를 입력하면 잘못된 입력을 알려주고 재입력을 요구한다.
숫자입력을 잘못한 경우는 게임횟수에 포함하지 않는다.
게임은 5번 진행하고 5번째 게임을 끝내면 다시할지 물어본다. 재시작(1), 종료(0)
0, 1 이외의 숫자를 입력하면 재입력을 요구해야 한다.
 */


public class QuRockPaperScissors
{
	public static void main(String[] args) throws IOException
	{
		int times = 1, exit = 1, comNum, inputNum;
		Scanner getScan	= new Scanner(System.in);
	
		System.out.println("★★★가위바위보game★★★");
		do {
			comNum = (int)((Math.random()*10)/3);
			if(comNum == 0)	continue;//0이면 다시 난수생성			
			
			System.out.println("무엇을 내시겠습니까?(1: 가위, 2:바위, 3:보)");
			inputNum = getScan.nextInt();			
			
			switch (inputNum) {
				case 1:	case 2: case 3: {
					System.out.print("사용자 : "+ setGame(inputNum) +
									"\t컴퓨터 : " + setGame(comNum) + "\n");
					resultGame(inputNum, comNum);
					break;
				}
				default :
				System.out.println("가위바위보 할줄 모르세요? 다시 태어나세요^^");
			}
			if(times == 5) {
				System.out.println("5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0)");
				for( ; ; ) {
					exit = getScan.nextInt();
					System.out.println(exit);
					if(exit == 1) {
						times = 1;
						break;
					}
					else if(exit == 0) {
						System.out.println("게임이 종료되었습니다. 감사합니다.");
						break;
					}
					else {
						System.out.println("잘못입력하셨습니다. 재시작(1), 종료(0)중에 입력하세요…..");
						continue;
					}
				}
			}
			times++;// 게임횟수 증가 1/5
		} while(exit != 0);
	}
	public static void resultGame(int userNum, int comeNum) {
		
		String win = "이겼습니다", loss = "졌습니다", draw = "비겼습니다";
		String[][] game_rule = new String[3][3];
		//게임규칙		0 = 가위,	1 = 바위,	2 = 보
			game_rule[0][0] =  draw; 
			game_rule[0][1] =  loss;
			game_rule[0][2] =  win;
	
			game_rule[1][0] =  win;
			game_rule[1][1] =  draw;	
			game_rule[1][2] =  loss;
			
			game_rule[2][0] =  loss;
			game_rule[2][1] =  win;
			game_rule[2][2] =  draw;
		System.err.println(game_rule[--userNum][--comeNum]);
	}
	public static String setGame(int num) {
		
		if(num == 1)		return "가위";
		else if(num == 2)	return "바위";
		else				return "보";
	}
}

