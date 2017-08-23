package arrays;

import arrays.sortings.MergeSort;

public class MaximizeSumOfConsecutiveDifferences {

	/**
	 *  if we made array in sorted order [A1,A2, A3,A4,A5,A6] 
	 *  and rearrange as like below,
	 *  
	 *  [a1, a6,a2,a5,a3,a4]
	 *  
	 *  total different sum = (a6-a1)+(a6-a2)+a(a5-a2)+(a5-a3)+(a4-a3)+ (a4-a3)
	 *  
	 *  sum=2*(a6+a5+a4)-2*(a1+a2+a3);
	 */
	public static int maxDiffInCyclicArray(int []arr){		
		MergeSort.mergersort(arr);
		int firstHalfSum = 0;
		int secondHalfSum = 0;
		int N = arr.length;
		
		for(int i=0;i<N/2; i++){	
			firstHalfSum += arr[i];
			secondHalfSum += arr[N-1-i];
		}
		return (2*secondHalfSum) -(2* firstHalfSum);		
	}
	
	
	public static void main(String[] args) {
		int arr[] = { 4, 2, 1, 8 };
		System.out.println(maxDiffInCyclicArray(arr));
	}

}
