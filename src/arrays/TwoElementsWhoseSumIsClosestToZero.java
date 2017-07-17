package arrays;

import java.util.Arrays;

/**
 * Algorithm 
1) Sort all the elements of the input array.

2) Use two index variables l and r to traverse from left and right ends respectively. Initialize l as 0 and r as n-1.
3) sum = a[l] + a[r]
4) If sum is -ve, then l++
5) If sum is +ve, then r–
6) Keep track of abs min sum.
7) Repeat steps 3, 4, 5 and 6 while l < r Implementation
 */

public class TwoElementsWhoseSumIsClosestToZero {
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 60, -10, 70, -80, 85 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int min_sum = Integer.MAX_VALUE, sum;

		int mleft = 0, mright = arr.length - 1;

		for (int left = 0, right = arr.length - 1; left < right;) {
			sum = arr[left] + arr[right];
			if (Math.abs(sum) < Math.abs(min_sum)) {
				min_sum = sum;
				mleft = left;
				mright = right;
			}
			if (sum > 0)
				right--;
			else
				left++;

		}
		System.out.println("Min elements are:" + arr[mleft] + ", "
				+ arr[mright] + " where sum is::" + min_sum);
	}

}
