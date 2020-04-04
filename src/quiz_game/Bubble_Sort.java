package quiz_game;

import java.util.Random;

public class Bubble_Sort {

	static int minIndex, maxIndex;
	static int[] arr = new int[10];
	
	
	public static void main(String[] args) {

		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = new Random().nextInt(100)+1;
			
			for(int j=0 ; j<i ; j++ ) {
				if(arr[j]==arr[i])	{
					i--;
				}
			}
		}
		
		arrPrint();
		System.out.println("=============Bubble Sort==============");
		
		
		for(int i=0 ; i<arr.length-1 ; i++) {
			for(int j=i+1 ; j<arr.length ; j++) {
				if(arr[i]>arr[j]) {
				
					swipe(i, j);
					arrPrint();
					
				}
				
			}
		}	
	}//main
	
	public static void arrPrint() {
		for(int i : arr)
			System.out.printf("%2d  ",i);
		System.out.println();
		
	}
	
	public static void swipe(int i, int minIndex) {
		int copy = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = copy;
	}
	
}














