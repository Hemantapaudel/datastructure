package arrays;

import java.util.Arrays;

public class MinimumLengthUnsortedSubarray {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 25, 35, 40, 32, 45, 50, 60 };
		int left = 0;
		int right = arr.length - 1;

		// Scan from left to right and find the first element which is greater
		// than the next element
		for (; left < arr.length - 1; left++) {
			if (arr[left] > arr[left + 1]) {
				break;
			}
		}
		System.out.println(left);
		// Scan from right to left t and find the first element which is smaller
		// than the next left element
		for (; right > 0; right--) {
			if (arr[right - 1] > arr[right]) {
				break;
			}
		}
		System.out.println(right);

		int lowerIndex = left + 1;
		int upperIndex = right - 1;

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = lowerIndex; i <= upperIndex; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("Min in subarray::" + min + " Max in Sub array::"
				+ max);

		if (arr[lowerIndex - 1] > min) {
			while (lowerIndex >= 0) {
				lowerIndex = lowerIndex - 1;
				if (arr[lowerIndex - 1] < min) {
					break;
				}
			}
		}

		if (arr[right] < max) {
			while (right < arr.length) {
				if (arr[right + 1] > max) {
					break;
				}
				right = right + 1;
			}
		}

		System.out.println("Sub array is  lowerIndex=:" + lowerIndex
				+ "  right = " + right);
		System.out.println(Arrays.toString(arr));
		for (int i = left; i <= right; i++)
			System.out.print("  " + arr[i]);

	}

}
