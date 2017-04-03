package arrays;

public class FindMaxSumOfSubArray {

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

	public static void main(String[] args) {
		int[] arr = { -1, 5, 3, -5, 5, 3, 5, 2, 3, -5, 5, 3, 5, -5, 6 };
		System.out.println(arr.length);
		maxSumOfSubArray(arr);
		findLargestSumContiguousSubarray(arr);
	}

	public static void findLargestSumContiguousSubarray(int[] arr) {
		int max_so_far = 0;
		int max_ending_here = 0;

		for (int i = 0; i < arr.length; i++) {
			max_ending_here = max_ending_here + arr[i];
			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
		}
		System.out.println("maximum so far=:" + max_so_far);
	}
}
