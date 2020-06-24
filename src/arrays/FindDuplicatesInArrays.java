package arrays;

/**
 * Given an array of (n +2) elements which contains elements from 1 to n, with
 * any of these numbers appearing any number of times. Find these repeating
 * numbers in O(n) and using only constant memory space. For example, let n be 7
 * and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
 **/

public class FindDuplicatesInArrays {

	public static int abs(int a) {
		return ((a > 0) ? a : -a);
	}

	public static void findDuplicatesInArrays(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int absValue = abs(arr[i]);
			if (arr[absValue] > 0) {
				arr[absValue] = -arr[absValue];
			} else {
				System.out.println("Duplicate is ::" + abs(arr[i]));
			}
		}
		
		for(int i =0; i < arr.length;i++){
			arr[i] = arr[i]>0? arr[i]: -arr[i];
		}
		
		
	}

	/**
	 * 
	 * complexity O(N) 
	 * 
	 */
	public static int maxRepeating(int[] arr, int n, int k) {
		// Iterate though input array, for every element arr[i], increment
		// arr[arr[i]%k] by k
		for (int i = 0; i < n; i++) {
			int index = arr[i] % k; // because it should lies on index of the array
			arr[index] = arr[index] + k;
		}

		// Find index of the maximum repeating element
		int max = arr[0], result = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = i;
			}
		}
		/* this code to get the original array back */
		for (int i = 0; i < n; i++)
			arr[i] = arr[i] % k;
		ArrayUtils.print(arr);
		// Return index of the maximum element
		System.out.println("Duplicate is ::" + result);
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 6, 6, 4, 5 };
		 //FindDuplicatesInArrays.findDuplicatesInArrays(arr);
		 FindDuplicatesInArrays.maxRepeating(arr, arr.length, arr.length-1);
	}
}
