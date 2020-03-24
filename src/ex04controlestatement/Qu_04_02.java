package ex04controlestatement;

import java.io.IOException;

public class Qu_04_02 {
/*
	����2) ���ϸ� : Qu_04_02.java
	�ϳ��� ���ڸ� �Է¹޾� �������� ���θ� �Ǵ��ϴ� ���α׷��� ���׿����ڸ� �̿��Ͽ� �����Ͻÿ�.	
	(System.in.read()�� ����ϼ���)
*/
	public static void main(String[] args) throws IOException {

		int input = System.in.read();
		int asciiCode = (int)input;
		
		String result = (asciiCode >= 48 && asciiCode <= 57) ? "���ڴ�" : "���ھƴ�"; 
		System.out.println(result);
	}

}
