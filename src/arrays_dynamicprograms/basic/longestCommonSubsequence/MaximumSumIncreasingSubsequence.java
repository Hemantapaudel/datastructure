package arrays_dynamicprograms.basic.longestCommonSubsequence;

import arrays.ArrayUtils;

public class MaximumSumIncreasingSubsequence {

	private static int maxSumIncSeq(int[] arr) {
		int[] maxSumSquence = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			maxSumSquence[i] = arr[i];
		}

		ArrayUtils.print(maxSumSquence);
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && (maxSumSquence[j] + arr[i]) > maxSumSquence[i]) {
					maxSumSquence[i] = maxSumSquence[j] + arr[i];
				}
			}
		}
		
		int max = 0;
		/* Pick maximum of all maxSumSquence values */
		for (int i = 0; i < arr.length; i++)
			if (max < maxSumSquence[i])
				max = maxSumSquence[i];
		return max;
	}

	public static void main(String[] args) {
		int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        System.out.println("Sum of maximum sum increasing "+
                           " subsequence is "+
                           maxSumIncSeq( arr ) );
}
	
	
}
