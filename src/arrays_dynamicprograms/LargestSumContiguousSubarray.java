package arrays_dynamicprograms;

public class LargestSumContiguousSubarray {
	
	
	public static int getSum(int arr[], int i, int j) {
		int sum = 0;
		while (i <= j) {
			sum = sum + arr[i];
			i++;
		}
		return sum;
	}

	public static void maxSumOfSubArray(int[] arr) {
		int lb = 0;
		int ub = 0;
		int maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int sum = getSum(arr, i, j);
				System.out.println("LB = " + i + " UB  = " + j + " sum = "
						+ sum);
				if (maxSum < sum) {
					lb = i;
					ub = j;
					maxSum = sum;
				}
			}
		}
		System.out.println("LB = " + lb + " UB  = " + ub + " sum = " + maxSum);
	}

	/**
	 * Kadane’s Algorithm: O(N)
Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
	 *
	 *This is not work if all number arr negative
	 */
	private static void largestSumContiguousSubarray(int []arr){
		int maximum_sub_array_sum =0;
		
		int max_ending_here =0;
		for(int element : arr){
			max_ending_here = max_ending_here + element;
			if(max_ending_here < 0){
				max_ending_here =0;
			}else if(max_ending_here > maximum_sub_array_sum){
				maximum_sub_array_sum = max_ending_here;
			}
		}
		System.out.println(maximum_sub_array_sum);
	}
	
	/**
	 * BEST SOLUTION
	 * 
	 *  This is work for all negative numbers array  
	 */
	private static void largestSumContiguousSubarray_Dynamic(int []arr){
		
		int max_sum =arr[0];
		int current_max = arr[0];
		
		for(int i =1;i< arr.length; i++){
			int element = arr[i];
			 current_max = Math.max(element, current_max + element);
			 max_sum = Math.max(current_max, max_sum);
		}
		System.out.println(max_sum);
		
	}
	
	public static void main(String[] args) {
		largestSumContiguousSubarray( new int[]{-1,-2,4,-2,1,5,-1});
		largestSumContiguousSubarray_Dynamic(new int[]{-1,-2,-4,-2,-1,-5,-1});
	}

}
