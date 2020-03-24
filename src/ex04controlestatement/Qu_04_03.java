package ex04controlestatement;

import java.util.Scanner;

public class Qu_04_03 {
/*
	����3) ���ϸ� : Qu_04_03.java
	����,����,���� ������ ����ڷκ��� �Է¹޾Ƽ�	����� ����  
	90���̻� A����, 
		80���̻� B����,
		....
		60���̸� F������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	�� switch���� ����ؾ� �մϴ�.(ScannerŬ������ ����ϼ���)
*/
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("korScore:");
		int korValue = scan.nextInt();

		System.out.println("engScore:");
		int engValue = scan.nextInt();

		System.out.println("mathScore:");
		int mathValue = scan.nextInt();
		
		double avg = ((korValue + engValue + mathValue) / 3.0) / 10; 

		switch ((int)avg) {
			case 10: case 9:
				System.out.println("A����"); break;
			case 8:
				System.out.println("B����"); break;
			case 7:
				System.out.println("C����"); break;
			case 6:
				System.out.println("D����"); break;
			default :
				System.err.println("F����");
		}
	}
}
