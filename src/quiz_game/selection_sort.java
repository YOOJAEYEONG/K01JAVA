package quiz_game;

import java.util.Random;

public class selection_sort {

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
		System.out.println("============Selection Sort============");
		
		
		for(int i=0 ; i<arr.length-1 ; i++) {
			for(int j=i+1 ; j<arr.length ; j++) {
				int loop=j;
				swipe(i, getCompare(i, j,loop));
			}
			arrPrint();
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
	
	public static int getCompare(int i, int j, int loop) {
		while(loop++<arr.length) {
			if(arr[i]<arr[j]) {
				j++;
				minIndex=i;
			}
			else {
				minIndex=j;
				getCompare(minIndex, j+1, loop);
			}
		}
		return minIndex;
	}
}
















