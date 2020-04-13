package ex16exception;

import java.util.InputMismatchException;
import java.util.Random;
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
/*
1: 가위 - 2: 바위 	= -1 : 졌다. 
1: 가위 - 3: 보	= -2 : 이겼다.
1: 가위 - 1: 가위 	= 0	 : 비겼다.
2: 바위 - 1: 가위	= 1	 : 이겼다
2: 바위 - 2: 바위	= 0	 : 비겼다
2: 바위 - 3: 보	= -1 : 졌다
3: 보    - 1: 가위	= 2  : 졌다.
3: 보    - 2: 바위	= 1  : 이겼다.
3: 보    - 3: 보	= 0  : 비겼다.
*/
/*

기존에 제작했던 파일을 복사해서 사용하면 되고 뒤에 Exception을 접미사로 붙이면 된다.

문제1) QuRockPaperScissorsException.java
가위바위보 게임에 다음 조건에 맞는 예외처리 구문을 추가하시오
숫자대신 문자를 입력할 경우 발생되는 예외를 처리하시오. (가위바위보 입력시, 재시작여부 입력시)
게임과 관련없는 숫자를 입력했을때 사용자정의 예외클래스를 통해 처리하시오.
예외처리 클래스명 : WrongNumberException

*/

class WrongNumberException extends Exception{
	
	
	public WrongNumberException() {}
	public WrongNumberException(String str) {
		super("테스트1"+str);
	}
	
}

public class QuRockPaperScissorsException {
	
	public static void main(String[] args) {
		int times = 0, exit = -2, comNum = 0, inputNum = 0;
		boolean reStart = true;
		Random random1 = new Random();
	
		System.out.println("★★★가위바위보game★★★");
		do {
			comNum = (int)(random1.nextInt(10)/3);
			if(comNum == 0) { continue;}//0이면 다시 난수생성			
			System.out.println("힌트: computer:"+setGame(comNum));
			System.out.println("무엇을 내시겠습니까 (1: 가위, 2:바위, 3:보)");
			
			try {
				inputNum = readInt("onGame");
				
			} catch (InputMismatchException | WrongNumberException numEx) {
				new WrongNumberException("강제적인 예외발생");
			}
				
			if(inputNum>=1 && inputNum <= 3) {
				times++;
				switch (inputNum-comNum) {
					case 1: case -2:
						System.out.print("사용자 : "+setGame(inputNum));
						System.out.print("\t컴퓨터 : "+setGame(comNum));
						System.out.println("\n ==== 이겼습니다 ====");
						break;
					case -1: case 2:
						System.out.print("사용자 : "+setGame(inputNum));
						System.out.print("\t컴퓨터 : "+setGame(comNum));
						System.out.println("\n ==== 졌습니다 ====");
						break;
					case 0:
						System.out.print("사용자 : "+setGame(inputNum));
						System.out.print("컴퓨터 : "+setGame(comNum));
						System.out.println("\n ==== 비겼습니다 ====");
						break;
				}
			}
			
			if(times == 5) {
				boolean isSwitch = true;
				System.out.println("5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0)");
				do{
					try {
						exit = readInt("exit");
						
						//알파벳을 입력하면 0값이 대입되는 문제가있음
						if(exit==1 || exit==0) {
							switch (exit) {
							
							case 1:
								times = 0;
								isSwitch = false;
								reStart = true;
								break;
							case 0:
								isSwitch = false;
								reStart = false;
								System.out.println("게임이 종료되었습니다. 감사합니다.");
								return;
							}
						}
						
						
					} catch (InputMismatchException | WrongNumberException numEx) {
						System.out.println("여기서 숫자만 입력가능합니다.");
						continue;
					}
				} while (isSwitch == true);
			}
		} while(reStart == true);
	}

	public static String setGame(int num) {
		
		switch (num) {
		case 1:			return "가위"; 
		case 2:			return "바위"; 
		case 3:			return "보"; 
		default: 		return null;
		}
	}
	public static int readInt(String strSwitch) throws WrongNumberException{
		
		Scanner scan = new Scanner(System.in);
		int inputVal = 0;
		for( ;;) {
			inputVal = scan.nextInt();
			
			if(strSwitch.equals("onGame")) {
				if(inputVal<1 || 3 < inputVal) {
					WrongNumberException onGameEx = new WrongNumberException("onGame");
					
				}
			}
			if(strSwitch.equals("exit")) {
				if(!(inputVal == 0 || inputVal == 1)) {
					WrongNumberException exitEx = new WrongNumberException("exit");
					
				}
			}
			return inputVal;
		}
	}
}




