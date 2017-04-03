package arrays;

public class Permutation {
	public static void permutation(char[] arr, int k, int n) {

		// k is a starting index
		// n is size of array

		if (n == k) {
			System.out.println(arr);
		} else {
			for (int i = k; i < n; i++) {
				char c = arr[i];
				arr[i] = arr[k];
				arr[k] = c;

				permutation(arr, k + 1, n);

				c = arr[i];
				arr[i] = arr[k];
				arr[k] = c;
			}
		}
	}

	public static void main(String[] args) {
		String arr = "ABC";
		permutation(arr.toCharArray(), 0, arr.length());

	}

}