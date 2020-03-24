package ex04controlestatement;

import java.io.IOException;

public class Qu_04_01 {

	/*	
	����1) ���ϸ� : Qu_04_01.java
	�ϳ��� ���ڸ� �Է¹޾� ����ڰ� �Է��� ���� �������� �Ǵ��Ͽ�
	���ڶ�� 2�ǹ�������� �ٽ� �Ǵ��Ͽ��� 2�ǹ���� ��쿡�� "2�� ��� �Դϴ�"��� ����Ͽ���. 
	�� �ܿ��� "2�� ����� �ƴմϴ�" ��� ����Ѵ�.
	��Ʈ] '0'�� �ƽ�Ű�ڵ尪�� 48 �Դϴ�. 
	(System.in.read()�� ����ϼ���)
	 */
	public static void main(String[] args) throws IOException {

		
		System.out.println("�ѱ��ڸ� �Է��Ҽ��ֽ��ϴ�:");
		int scan = System.in.read();
		int asciiVal = (int)scan;
		
		if(asciiVal >= 48 && asciiVal <= 57) 
			if( scan%2 == 0 )
				System.out.println("2�� ����Դϴ�.");
			else
				System.out.println("2�� ����� �ƴմϴ�.");
		else
			System.out.println("2�� ����� �ƴմϴ�.");
			
	}

}
