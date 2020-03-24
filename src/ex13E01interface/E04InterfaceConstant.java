package ex13E01interface;

import java.util.Scanner;

interface Week{
	int MON=1, TUE =2, WED=3, THU=4, FRI=5, SAT=6, SUN=7;
	
}



public class E04InterfaceConstant {

	public static void main(String[] args) {

		System.out.println("오늘은 요일을 선택하세요");
		System.out.println("1.월요일~7.일요일");
		System.out.println("선택(정수입력):");
		
		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();
		
		switch(sel) {
		
		case Week.MON:
			System.out.println("주간회의");
			break;
		case Week.TUE:
			System.out.println("프로젝트 기획회의");
		case Week.WED:
			System.out.println("진행사항 보고");
			break;
		case Week.THU:
			System.out.println("축구시합");
		case Week.FRI:
			System.out.println("프로젝트 마감");
		case Week.SAT:
			System.out.println("가족과 즐거운시합");
		case Week.SUN:
			System.out.println("휴일");
		}
		
	}
}
