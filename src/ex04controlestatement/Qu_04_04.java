package ex04controlestatement;
/*
����4)���� ������ �ΰ��� if���� ����ϰ� �ִ�.�̸� �ϳ��� if������ �����غ���
���ϸ� : Qu_04_04.java

class Qu_04_04
{
   	public static void main(String[] args)
   	{
           int num = 120;
         if (num > 0) {
                	if ((num % 2) == 0) {
                       	System.out.println("����̸鼭 ¦��");
                	}
         }
   	}
}
*/
public class Qu_04_04 {

	public static void main(String[] args) {

	      int num = 120;
	      if (num > 0 && (num % 2) == 0) 
	    	  System.out.println("����̸鼭 ¦��");
	}
}
