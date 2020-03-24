package ex02variable;

public class E06EscapeSequence {

	public static void main(String[] args) {

		/*
		Escape Sequence(이스케이프 시퀀스) : 특정형식에 맞게 출력하기위해
		사용되는 문자로 \(역슬러쉬)를 붙여주면 된다.
		 */
		
		//tab탭 기능. 스페이스 4칸이 띄워짐.
		System.out.println("4월엔 벚꽃~~!");
		System.out.println("4월엔 \t벚꽃~~!");
		
		//줄바꿈(Line feed) 기능
		System.out.print("KOSMO에 오신걸 환영합니다.\n");
		System.out.print("열심히\n해봅시다.\n");
		
		//: 쌍따옴표를 표현하고 싶을때 사용
//		System.out.println("나는 "개발자"가 되고 싶어요");[에러발생]
		System.out.println("나는 \"개발자\"가 되고 싶어요");
		
		
		/*
		printf() : 문자열을 서식에 맞춰서 출력해야할때 사용
		 */
		int kor=81, eng=97, math=79;
		
		System.out.printf("국어:%d, 영어:%d, 수학:%d%n", kor, eng, math);
		System.out.println("\n국어:" + kor + ", 영어:" + eng + ", 수학:" + math);
		double avg = (kor+eng+math) / 3.0;
		System.out.printf("평균점수:%f%n%n", avg);
		
		/*
		자리수 지정하기
		Ex) %4d : 정수 출력시 전체자리수를 4자리로 표현
			%6.2f 또는 %-6.2f: 실수 출력시 전체자리수는 6자리, 소수이하 2자리로 표현.
			양수는 우측, 음수는 좌측정렬됨.
		 */
		System.out.printf("국어:%d, 영어:%d, 수학:%d%n" + " 평균:%f %n", kor, eng, math, avg);
		System.out.printf("국어:%6d, 영어:%6d, 수학:%6d%n" + " 평균:%7.2f %n", kor, eng, math, avg);
		System.out.printf("국어:%-6d, 영어:%-6d, 수학:%-6d%n" + " 평균:%-7.2f %n", kor, eng, math, avg);
		
		
	}

}
