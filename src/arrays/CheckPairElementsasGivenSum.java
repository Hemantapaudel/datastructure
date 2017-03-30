package arrays;

import java.util.Arrays;

/**
 * 
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 * 
 * Algorithm hasArrayTwoCandidates (A[], ar_size, sum) 1) Sort the array in
 * non-decreasing order. 2) Initialize two index variables to find the candidate
 * elements in the sorted array. (a) Initialize first to the leftmost index: l =
 * 0 (b) Initialize second the rightmost index: r = ar_size-1 3) Loop while l <
 * r. (a) If (A[l] + A[r] == sum) then return 1 (b) Else if( A[l] + A[r] < sum )
 * then l++ (c) Else r-- 4) No candidates in whole array - return 0
 */
public class CheckPairElementsasGivenSum {
	
	public static void printPairElementsHavingGivenSum(int[] arr, int sum) {
		Arrays.sort(arr);
		boolean isPairFound=false;
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			if ((arr[left] + arr[right]) == sum) {
				System.out.println("sum of the pair::a[left]=" + arr[left]+ " a[right] =" + arr[right]);
				right = right - 1;
				left = left + 1;
				isPairFound= Boolean.TRUE;
			} else if ((arr[left] + arr[right]) > sum) {
				right = right - 1;
			} else {
				left = left + 1;
			}
		}
		if(isPairFound == Boolean.FALSE){
			System.out.println("There is no pair element which having sum "+sum);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 12, 5, 25, 35, 7, 8, 10 };
		printPairElementsHavingGivenSum(arr,60);
		printPairElementsHavingGivenSum(arr,21);
	}

}
