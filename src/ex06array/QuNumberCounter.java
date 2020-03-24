package ex06array;

public class QuNumberCounter {

	public static void main(String[] args) {
/*
	문제1) 파일명 : QuNumberCounter.java
	다음에 주어진 answer 배열에는 1~4까지의 정수가 여러개 저장되어 있다. 
	배열 전체의 데이터를 읽어서 각 정수가 몇개씩 있는지 
	카운트하여 counter 배열에 순서대로 저장하시오.

	int[] answer = { 1,4,4,3,1,4,4,2,1,3,2  };
	int[] counter = new int[4];

	실행결과]
	counter[0] => 3
	counter[1] => 2
	counter[2] => 2
	counter[3] => 4
*/
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2  };
		int[] counter = new int[4];
		
		for(int e : answer) {
			if(e == 1) 			counter[0] += 1;
			else if(e == 2) 	counter[1] += 1;
			else if(e == 3) 	counter[2] += 1;
			else if(e == 4) 	counter[3] += 1;
			}
		
		System.out.println("counter[0] => " + counter[0]);
		System.out.println("counter[1] => " + counter[1]);
		System.out.println("counter[2] => " + counter[2]);
		System.out.println("counter[3] => " + counter[3]);
		
/*
 * 	라이브코딩
 * 
 * 		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2  };
		int[] counter = new int[4];//배열 크기를 지정하여 선언하면 0으로 자동 초기화된다.
 * 		
 * 		//배열의 크기만큼 반복하면서 각 요소를 읽어 온다.
 * 		for(int i=0 ; i<answer.length ; i++){
 *			//숫자1이 발견되면 counter배열의 0번방을 +1 시켜준다.
 *
 *			/*
 *			if(answer[i]==1) {
 *				counter[0]++; 
 *				//0으로 초기화가 되어있기 때문에 ++연산자를 바로 사용할 수 있다.
 *	 		}
 *			else if(answer[i]==1) {
 *				counter[1]++;
 *	 		}
 *			else if(answer[i]==1) {
 *				counter[2]++;
 *	 		}
 *			else if(answer[i]==1) {
 *				counter[3]++;
 *	 		}
 *			/*
 *
 *			//위 if-else문을 한줄로 수정하면 다음과 같다.
 *			//검색한 숫자가 만약1이라면 counter배열의 0번 인덱스를 +1 증가시키므로
 *			//아래와 같이 표현할 수 있다.
 *			counter[answer[i]-1]++;
 *
 *
 *
 *			//counter 배열 출력
 *			for(int i=0 ; i<counter.length ; i++)	{
 *				System.out.printf("counter[%d](%d)의 갯수):%d\n",
 *					i, i+1, counter[i]
 *			}
 *
 *
 * 		}
 */		
		
		
		
	}
	
}
 