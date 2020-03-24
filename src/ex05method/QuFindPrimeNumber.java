/*
문제 5-4) 파일명 : QuFindPrimeNumber.java  (난이도:상)
전달된 값이 소수인지 아닌지를 판단하여 소수인 경우 true를 아니면 false를 반환하는 메소드를 정의하고,
이를 이용해서 1부터 100사이의 소수를 전부 출력하는 main메소드를 정의하자.
메소드명 : isPrimeNumber()
소수란 : 특정 정수를 나눌수 있는것이 1과 자기자신밖에 없는 수.
실행예 :2
3 
5
7
……중략…….

97
///////////////////////////////////
2
3 / 1 = 3.0
3 / 2 = 1.5
3 / 3 = 1.0
4 / 1 = 4.0
4 / 2 = 2.0 
4 / 3 = 1.9 
4 / 4 = 1.0
5
6 / 1 = 6.0
6 / 2 = 3.0
6 / 3 = 2.0
6 / 4 = 1.5
6 / 5 = 1.2
7 / 1 = 7.0		몫num	나머지0
7 / 2 = 3.5
7 / 3 = 2.9
7 / 4 = 1.7
7 / 5 = 1.4
7 / 6 = 1.1
7 / 7 = 1		몫1	나머지 0
8 / 1 = 8.0		몫num / 나머지0
8 / 2 = 4.0
8 / 3 = 2.6
8 / 4 = 2.0
8 / 5 = 1.6
8 / 6 = 1.3
8 / 7 = 1.1
8 / 8 = 1.0		몫1 / 나머지 0
13 / 1 = 13.0
13 / 2 = 6.5
13 / 3 = 4.3
13 / 4 = 3.2
13 / 5 = 2.6
13 / 6 = 2.1
13 / 7 = 1.8
13 / 8 = 1.6
13 / 9 = 1.4
13 / 10= 1.3
13 / 11= 1.x
13 / 12= 1.x
13 / 13= 1.0
……중략…….
97
 */
package ex05method;

import java.util.Scanner;

public class QuFindPrimeNumber {

	/*
	public static void main(String[] args) {
	
		for( int primeNum = 2; primeNum <= 100; primeNum++) 
			if(isPrimeNumber(primeNum)) 
				System.out.println(primeNum);
	}

	static boolean isPrimeNumber(int num)	{
		boolean result = true;
		for(int testNum1 = 2; testNum1 <= (num-1) ; testNum1++) 
			if(num%testNum1 == 0 ) { 
				result = false;
				break;
			}
			else
				result = true;
		return result;
	}
	*/
	//강사님코딩
	public static void main(String[] args) {
		
		for(int i = 1; i <= 100 ; i++) {
			
			if(isPrimeNumber(i)==true){
				System.out.println("소수=" + i);
			}
		}
	}
	
	static boolean isPrimeNumber(int num) {
		
		/*
		1과 자신을 제외한 숫자로 나눠서 떨어지면 소수가 아니므로 그 이후는
		검사할 필요가 없다. 판단되는 즉시 false를 반환한다.
		 */
		if(num==1) { //1은 소수가 아니므로 무조건 false를 반환한다.
			return false;
		}
		else {
			/*
			모든 자연수는 1과 자신으로 나눠지므로 두 조건을 제외한
			나머지 수로 나눠서 떨어지는지를 판단한다.
			 */
			for(int i = 2 ; i<num ; i++) {
				if(num%i==0)
					return false;//함수에서 return을 만나면 종료된다.
			}
		}
		return true;//소수인 경우 true 반환
	}
}
