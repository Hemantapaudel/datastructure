package arrays_dynamicprograms.knapsack;

public class SubsetSumProblem {

	public static boolean subsetSumByRecursive(int[] input, int n, int sum) {
		if (sum == 0) {
			return true;
		}
		if (n == 0) {
			return false;
		}
		// check if last element is more than sum, then ignore last element
		if (input[n - 1] > sum) {
			return subsetSumByRecursive(input, n - 1, sum);
		}
		// recursive call
		// a. include last element
		// b. exclude last element
		return subsetSumByRecursive(input, n - 1, sum - input[n - 1])
				|| subsetSumByRecursive(input, n - 1, sum);
	}

	public static boolean subsetsum(int[] input, int total) {
		boolean[][] M = new boolean[input.length + 1][total + 1];
		// for sum zero, it is always true
		for (int i = 0; i < M.length; i++) {
			M[i][0] = true;
		}
		for (int i = 1; i < M.length; i++) {
			for (int j = 1; j < M[0].length; j++) {
				// if total is less than input value then copy the i-1th rows
				boolean isTotalLessThanInputValue = input[i - 1] - j > 0;
				if (isTotalLessThanInputValue) {
					M[i][j] = M[i - 1][j];
				} else {
					M[i][j] = M[i - 1][j] || M[i - 1][j - input[i - 1]];
				}
			}
			// System.out.println( Arrays.toString(M[i]));
		}
		return M[input.length][total];
	}

	public static void main(String[] args) {
		int arr1[] = { 2, 3, 7, 8 };
		System.out.println(subsetsum(arr1, 11));
		System.out.println(subsetSumByRecursive(arr1, arr1.length, 11));
	}
}
