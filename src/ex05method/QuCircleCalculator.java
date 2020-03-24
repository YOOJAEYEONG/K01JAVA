package ex05method;

import java.util.Scanner;

/*
원의 반지름을 파라메타로 전달하면 원의넓이와 둘레를 계산하여 반환하는 메소드를 각각 정의하자. 이를 호출하는 main 메소드를 정의하라.
메소드명 : circleArea() > 원의넓이, circleRound() > 원의둘레
-넓이공식 : 3.14 * 반지름 * 반지름
-둘레공식 : 2 * 3.14 * 반지름
실행예 :
원의 둘레(5.5) : 34.54
원의 넓이(5.5) : 94.985
 */
public class QuCircleCalculator {

	public static void main(String[] args) {

		System.out.println("원의 반지름값 입력:");
		Scanner scan_value = new Scanner(System.in);
		double radius = scan_value.nextDouble();
		
		System.out.printf("원의 둘레 (%.1f) : %.2f%n", radius, circleRound(radius));
		System.out.printf("원의 둘레 (%.1f) : %.3f%n", radius, circleArea(radius));
	}
	static double circleArea(double radius) {
		double area_value = 3.14 * radius * radius;
		return area_value;
	}
	static double circleRound(double radius) {
		double round_value = 2 * 3.14 * radius;
		return round_value;
	}
}
