package ex02variable;

/*
반지름이 10인 원의 넓이를 구해 출력하시오.
단, 면애의 타입을 int, float, double형
세가지로 선언하여 각각 출력해야한다.
변수명] 
	int형 : area_int
	float형 : area_float
	double형 : area_double
공식]
	원의넓이 = 반지름 * 반지름 * 3.14
 */
public class Qu_03 {

	public static void main(String[] args) {

		int radius = 10;
		
		int area_int;
		float area_float;
		double area_double;
		
		area_int = (int)(radius * radius * 3.14);
		System.out.println("area_int:" + area_int);
		
		area_float = radius * radius * 3.14F;
		System.out.println("area_int:" + area_float);
		
		area_double = radius * radius * 3.14;
		System.out.println("area_int:" + area_double);
	}

}
