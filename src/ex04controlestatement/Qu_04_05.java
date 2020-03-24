package ex04controlestatement;
/*����5) �Ʒ� �ڵ带 ���׿����ڸ� ������� ���� if~else������ �����غ���.
���ϸ� : Qu_04_05.java
   public static void main(String[] args)
   {
         	int num1=50, num2=100;
         	int big, diff;
         	
         	big = (num1>num2)? num1:num2; //����?��:����;
         	System.out.println(big);
         	
         	diff = (num1>num2)? num1-num2: num2-num1;
         	System.out.println(diff); 
   }
������]
---------- java ----------
100
50 
*/
public class Qu_04_05 {

	public static void main(String[] args) {

     	int num1=50, num2=100;
     	int big, diff;
     	
     	if(num1>num2)	big = num1;
     	else     		big = num2;
     	System.out.println(big);
     	
     	if(num1>num2)	diff = num1-num2;
     	else     		diff = num2-num1;
     	System.out.println(diff); 
	}
}
