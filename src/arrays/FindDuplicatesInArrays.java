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
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 6, 6, 4, 5 };
		FindDuplicatesInArrays.findDuplicatesInArrays(arr);
	}
}
