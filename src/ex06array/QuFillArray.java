package ex06array;

import java.io.IOException;
import java.util.Scanner;

public class QuFillArray {

	public static void main(String[] args) throws IOException{

/*
문제3) 홀수/짝수 구분하여 배열채우기
파일명 : QuFillArray.java
길이가 10인 배열을 선언한후 총 10개의 정수를 입력받아 순서대로 저장한다. (첫번째배열)
그리고 순서대로 저장된 숫자들을 홀수는 배열의 앞에서 부터 채워나가고 짝수는 배열의 끝에서부터 채워나간다.(두번째배열)

출력예시) 총 10개의 정수를 입력하시오.
1 2 3 4 5 6 7 8 9 10

순서대로입력된결과: 1 2 3 4 5 6 7 8 9 10
홀수/짝수 구분입력결과 : 1 3 5 7 9 10 8 6 4 2
 */
	
/*
		//내가 한 코딩
		int[] arr = new int[10];//순서대로 입력되는 배열
		int[] arr2 = new int[10];//홀짝 구분입력되는 배열
		int indexOdd = 0, indexEven = arr2.length-1;
		Scanner scanNum = new Scanner(System.in);
		
		for(int a=0 ; a < arr.length ; a++) {
			int inputNum = scanNum.nextInt();
			arr[a] = inputNum;
			if(inputNum %2 == 0) 
				arr2[indexEven--] = inputNum;
			else 
				arr2[indexOdd++] = inputNum;
		}
		System.out.print("순서대로 입력된 결과 : ");
		for(int a : arr)
			System.out.print(" "+ a); 
		
		System.out.print("\n홀수/짝수 구분 입력 결과 : ");
		for(int a : arr2)
			System.out.print(" "+ a); 
		System.out.println();
*/
		
		Scanner scanNum = new Scanner(System.in);
		int[] arr = new int[10];
		int[] arr2 = new int[10];
		
		int indexStart = 0; //arr2의 첫번째 인덱스 지정
		int indexEnd = arr.length - 1; //arr2의 마지막 인덱스 지정
		
		
		for(int a=0 ; a < arr.length ; a++) {
			int inputNum = scanNum.nextInt();
			//첫번째 배열에는 입력한 순서대로 배열을 채운다.
			arr[a] = inputNum;
			
			//홀수, 짝수를 구분하여 홀수이면 앞부터, 짝수는 뒤부터 채움
			if(inputNum %2 == 0) //홀수이면 앞부터 채우고, 인덱스 +1증가
				arr2[indexStart++] = inputNum;
			else {//짝수이면 뒤에서부터 채우고, 인덱스 -1 감소
				arr2[indexEnd--] = inputNum;
			}
			
			
		}
		System.out.println("순서대로 입력된 결과 : ");
		for(int a=0 ; a < arr.length ; a++) {
			System.out.print(arr[a]+" ");
		}
		
		
		System.out.println();
		
		
		System.out.println("홀짝구분 입력된 결과 : ");
		for(int a=0 ; a < arr2.length ; a++) {
			System.out.print(arr2[a]+" ");
		}
		
		
		
		
		
		
		
		
		
		
	}
}
