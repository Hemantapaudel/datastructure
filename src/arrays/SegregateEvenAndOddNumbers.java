package arrays;

import java.util.Arrays;

/*
 * Given an array A[], write a function that segregates even and odd numbers.
 *  The functions should put all even numbers first,
 *  and then odd numbers.
 */

public class SegregateEvenAndOddNumbers {

	public static void segregateOsAnd1s(int []arr){
		int left = 0;
		int right =arr.length-1;
		while(left<right){
			while ((arr[left]  == 0) && (left < right)){
				left++;
			}
			while ((arr[right]  == 1) && (left < right)){
				right--;
			}
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
			
		}
		System.out.println("After move all even number left::"
				+ Arrays.toString(arr));
	}
	
	public static void segregateEvenNodd(int[] arr) {

		int right = arr.length - 1;
		int left = 0;
		while (left < right) {

			while ((arr[left] % 2 == 0) && (left < right)){
				left++;
			}
			while ((arr[right] % 2 == 1) && (left < right)){
				right--;
			}
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		System.out.println("After move all even number left::"
				+ Arrays.toString(arr));
	}

	public static void segregate012(int[] arr) {

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		SegregateEvenAndOddNumbers.segregateEvenNodd(arr);

		int[] binaryArray ={0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1};
		segregateOsAnd1s(binaryArray);
	}

}
