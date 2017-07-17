package arrays;

public class FindSubarrayWithGivenSum {

	private static void printSubArrayHavingGivenSum(int[] arr, int sum) {
		int currentSum = 0;
		int start = 0;
		for (int end = 0; end < arr.length; end++) {
			currentSum = currentSum + arr[end];
			while (currentSum > sum && start <= end) {
				currentSum = currentSum - arr[start];
				start++;
			}
			if (currentSum == sum) {
				ArrayUtils.print(arr, start, end);
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		printSubArrayHavingGivenSum(arr, 23);
	}
}
