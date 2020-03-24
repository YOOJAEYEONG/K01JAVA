package ex04controlestatement;
/*
문제1] 다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.
파일명 : Qu_04_06.java
출력]
	*
	* *
	* * *
	* * * *
	* * * * *
 */
public class Qu_04_06 {

	public static void main(String[] args) {
		
		int count = 1, length = 1;

		while (count++ <= 5) {	
			while (length-- > 0) 
				System.out.print("* ");
			System.out.println();
			length = count;
		}
	}
	
	
	
}