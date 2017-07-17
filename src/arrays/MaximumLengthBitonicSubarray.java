package arrays;

public class MaximumLengthBitonicSubarray {

	static int bitonic(int[] arr) {

		int[] inc = new int[arr.length];
		int[] dec = new int[arr.length];

		inc[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			System.out.println(arr[i - 1] <= arr[i]);
			inc[i] = arr[i - 1] <= arr[i] ? inc[i - 1] + 1 : 1;
			System.out.println(inc[i]);
		}

		dec[arr.length - 1] = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			dec[i] = arr[i + 1] <= arr[i] ? dec[i + 1] + 1 : 1;
		}
		ArrayUtils.print(inc);
		ArrayUtils.print(dec);

		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((inc[i] + dec[i] - 1) > max) {
				max = inc[i] + dec[i] - 1;
			}
		}
		return max;

	}

	public static void main(String[] args) {

		int arr[] = { 12, 4, 78, 90, 45, 23 };
		System.out.println(bitonic(arr));

	}

}
