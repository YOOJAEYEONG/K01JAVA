package ex06array;

/*
 * for-each문
 * 	: 배열의 일부가 아니라 전체를 참조해야할때 주로 사용하는 개선된 for 문이다.
 * 	배열의 요소를 참조형태로 가져와서 사용한다.
 * 	그러므로 참조의 목적으로만 사용해야하고, 값의 변경은 기본적으로 허용하지 않는다.
 * 	(변경하고 싶으면 각각 인덱스에 접근하여 변경해야함.)
 * 
 * 형식]
 * 	for(자료형 참조변수 : 배열의 이름) {
 * 		실행문장;
 * 		[참조변수를 통해 배열의 요소값 출력가능]
 * 	}
 */
public class E07ForEachBasic {

	public static void main(String[] args) {

		
		int[] arr = {1,2,3,4,5};
		int sum=0;
		
		for(int i=0; i < arr.length ; i++)
			sum += arr[i];
		
		System.out.println("기본for문의 합계"+ sum);
		
		sum=0;
				
//		배열 arr의 요소를 하나씩 참조하여 출력하고, 더이상 참조할 요소가
//		없을때 for 문이 자동으로 종료된다.
		for(int i : arr) {
			System.out.print(i+" ");
			sum += i;
		}
		
		System.out.println("\nforeach문을 이용한 합계:"+sum);
		/////////////////////////////////////////////
//		참조형태로 각요소를 가져와서 변수b에 할당하는 방식이므로
//		아래 증가연산자를 통해 증가하는 것은 실제 배열에 적용되지 않은다.
//		해당 foreach문 내에서만 증가한다.
		System.out.println("배열arr의 요소값 1 증가시기기");

		for(int b : arr) {
			b++;
			System.out.print(b+" ");//+1증가된 값이 출력됨
		}
		System.out.println();
		
		
		
		System.out.println("배열의 arr요소 재출력하기");
		for(int c : arr)
			System.out.print(c + " ");
		System.out.println();
//			+1증가된 부분이 기존 배열에 적용되지 않으므로 기존의 값이 그대로 출력된다.

		/////////////////////////////////////////////
		
		System.out.println("2차원 배열을 foreach문으로 출력하기");
		
		int[][] twoDim = {
				{1,2,3,4},
				{10,20,30,40},
				{100,200,300,400}
		};
//		2차원 배열은 1차원 배열 여러개를 겹쳐놓은 형태이므로 출력시에는
//		우선 하나의 행(1차원배열)을 가져와서...
		for(int[] a: twoDim) {
			for(int b : a)//각 요소를 하나씩 참조하여 출력한다.
				System.out.print(b + " ");
			System.out.println();
		}
	}
}














