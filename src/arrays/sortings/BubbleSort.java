package arrays.sortings;

import java.util.Arrays;

/**
 * complexity is O(n^2)
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 4, 6, 2, 8, 5, 6, 9, 6, 7 };
		int n = arr.length;
		for (int pass = n - 1; pass >= 0; pass--) {
			for (int i = 0; i < pass - 1; i++) {
				// compare ith and i+1th elements, swap if ith element is larger
				// than i+1th element
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
