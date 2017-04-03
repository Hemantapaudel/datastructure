package arrays.sortings;

import java.util.Arrays;

/**
 * best and worst case O(nlogn)
 */
public class RadixSort {

	/** Radix Sort function **/
	public static void sort(int[] arr) {

		// get maximum element of the array

		int i = 0, max = arr[0], n = arr.length;
		int[] b = new int[n];
		for (i = 1; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
		}

		int exp = 1;

		while (max / exp > 0) {
			int[] bucket = new int[10];

			// let (arr[i] / exp) %10 is 9 and bucket[9] index having 3, then
			// bucket[9] = bucket[9]+1 =>> bucket[9] = 4;
			for (i = 0; i < n; i++) {
				bucket[(arr[i] / exp) % 10]++;
			}
			System.out.println(Arrays.toString(bucket));
			// if bucket[0]= 2 and bucket[1] =3 , after this for loop, bucket[1]
			// = 5
			for (i = 1; i < 10; i++) {
				bucket[i] = bucket[i] + bucket[i - 1];
			}
			System.out.println(Arrays.toString(bucket));

			for (i = n - 1; i >= 0; i--) {
				b[--bucket[(arr[i] / exp) % 10]] = arr[i];
			}
			System.out.println(Arrays.toString(b));

			for (i = 0; i < n; i++) {
				arr[i] = b[i];
			}
			exp *= 10;
		}
	}

	/** Main method **/
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 2, 1 };

		/*
		 * Scanner scan = new Scanner(System.in);
		 * System.out.println("Radix Sort Test\n"); int n, i;K
		 *//** Accept number of elements **/
		/*
		 * System.out.println("Enter number of integer elements"); n =
		 * scan.nextInt();
		 *//** Create integer array on n elements **/
		/*
		 * int arr[] = new int[n];
		 *//** Accept elements **/
		/*
		 * System.out.println("\nEnter " + n + " integer elements"); for (i = 0;
		 * i < n; i++) arr[i] = scan.nextInt();
		 *//** Call method sort **/
		sort(arr);
		/** Print sorted Array **/
		System.out.println("\nElements after sorting ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

	}

}