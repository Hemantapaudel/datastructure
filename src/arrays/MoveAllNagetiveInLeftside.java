package arrays;

import java.util.Arrays;

/**
 * Move all negative number in left side and positive number in right side in an
 * array.
 * 
 * if array is [ 1 , -2 , 3 , 4 , 5 , -6 ] then it should like [ -2, -6 , 1 , 3
 * , 4 , 5 ]
 */

public class MoveAllNagetiveInLeftside {
	/*
	 * Method 1. this method does not maintain the order
	 */
	public static void moveAllNagetiveInLeft(int[] arr) {
		System.out.println("Before  modified  an array::"+ Arrays.toString(arr));
		int leftIndex = 0;
		int rightIndex = arr.length - 1;
		while (leftIndex < rightIndex) {
			while ((arr[leftIndex] < 0) && leftIndex < rightIndex) {
				leftIndex++;
			}
			while ((arr[rightIndex] > 0) && leftIndex < rightIndex) {
				rightIndex--;
			}
			if (leftIndex < rightIndex) {
				exChangeElement(arr, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;
			}
		}
		System.out.println("After modified  an array::" + Arrays.toString(arr));
	}
	
	

	private static void exChangeElement(int[] arr, int leftIndex, int rightIndex) {
		int temp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = temp;
	}

	
	public static void main(String[] args) {
		int[] arr = { 1, 2, -3, 4, 5, -6, 7 };
		moveAllNagetiveInLeft(ArrayUtils.copy(arr));
	}
}
