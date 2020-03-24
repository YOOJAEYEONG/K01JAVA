package ex04controlestatement;

public class Qu_04_07 {

/*
문제2] 1~100까지의 숫자중 3의배수 이거나 7의배수인 숫자의 합을 구하는 프로그램을 작성하시오. 
단, 3과 7의 공배수인 경우 합에서 제외해야 한다. 
출력의결과는 누적되는 모든 수를 콘솔에 print한다.
 */
	public static void main(String[] args) {

		int sum = 0;
//		for(int value = 1 ; value <= 100; value++)
//			if(!(value%3==0 && value%7==0)) 
//				if(value%3==0) {
//					sum += value;
//					System.out.print("+" + value);
//				}
//				else if (value%7==0) {
//					sum += value;
//					System.out.print("+" + value);
//				}
//		System.out.println("=" + sum);
//		
		for(int i = 1; i <= 100 ; i++) {
			if(i%3==0 || i%7==0) {//3의 배수이거나7의배수
				if(i%(3*7)!=0) {//3과 7의 공배수가 아닌 정수
					sum += i;
					System.out.println(i);
				}
			}
		}
		System.out.println(sum);
	}
	
		
}
