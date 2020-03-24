package ex05method;

import java.io.IOException;
import java.util.Scanner;

/*
문제5-3) 파일명 : QuTemperature.java  (난이도:중)
섭씨(Celsius)를 입력받아서 화씨(Fahrenheit)로 변환하여 리턴하는 함수와
화씨를 입력받아서 섭씨로 변환하여 리턴하는 함수를 만들어라.
공식]0'C ==> 32'F   / 32'F ==> 0'C
  화씨 = 1.8 * 섭씨 + 32
  섭씨 = (화씨 - 32) / 1.8
 */



public class QuTemperature {
	
	/*
	내가 코딩한것

	public static void main(String[] args) throws IOException  {

		boolean shutdown = true;
		
		System.out.println("★★★섭씨 <==> 화씨 변환기★★★");

		do
		{
			Scanner scanInput = new Scanner(System.in);
			System.out.println("온도값을 입력하세요 : ");
			double temp = scanInput.nextDouble();
			System.out.printf("[1. %.1f'F => 섭씨로 변환]\n" +
					 		  "[2. %.1f'C => 화씨로 변환]\n" +
					 		  "[3. 종료하기]\n[4. 처음으로]\n", temp, temp);
		
			int selec_menu = System.in.read();
			switch (selec_menu) {
				case 49:
					System.out.printf("%.1f'F => %.1f'C\n", temp, fahrenheitToCelsius(temp));
					break;
				
				case 50:
					System.out.printf("%.1f'C => %.1f'F\n", temp, celsiusToFahrenheit(temp));
					break;
				
				case 51:
					System.out.println("종료합니다.");
					shutdown = false; break;
				
				case 52:
					System.out.println("처음으로 왔습니다.");
					shutdown = true;
				default :
					continue;
			}
		} while (shutdown);
	}
	
	static double celsiusToFahrenheit (double input) {
		
		double fahreheit = 1.8 * input + 32;
		return fahreheit;
	}
	static double fahrenheitToCelsius(double input) {
		
		double celsius = (input - 32) / 1.8;
		return celsius;
	}
	*/
	public static void main(String[] args) throws IOException  {
		
		System.out.println("섭씨20도 -> 화씨");
		System.out.println(celsiusToFahrenheit(20));
		System.out.println("화씨98도 -> 섭씨");
		System.out.println(celsiusToFahrenheit(98));
		
	}
	
	static double celsiusToFahrenheit (int fah) {
		
		return 1.8 * fah + 32; //return에 변수없이 수식이 가능하다 !
	}
	static double fahrenheitToCelsius(int cel) {
		
		return (cel - 32) / 1.8;
	}
}



