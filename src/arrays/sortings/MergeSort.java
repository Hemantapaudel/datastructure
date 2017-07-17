package arrays.sortings;

public class MergeSort {

	public static void mergersort(int[] arr) {
		int n = arr.length;
		if (n < 2) {
			return;
		}
		// divide the array into two arrays
		int mid = n / 2;
		//System.out.println("mid ==" + mid);
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		for (int i = 0; i < mid; i++) {
			//System.out.println(arr[i]);
			left[i] = arr[i];
		}
		//System.out.println("---------------");
		for (int i = mid; i < n; i++) {
			//System.out.println(arr[i]);
			right[i - mid] = arr[i];
		}
		// dividing the array recursively
		mergersort(left);
		mergersort(right);

		// merging two sorted array into one array
		merge(left, right, arr);
	}

	public static void merge(int[] left, int right[], int arr[]) {
		int ln = left.length;
		int rn = right.length;
		int i = 0, j = 0, k = 0;
		while (i < ln && j < rn) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				i = i + 1;
			} else {
				arr[k] = right[j];
				j = j + 1;
			}
			k = k + 1;
		}
		while (i < ln) {
			arr[k] = left[i];
			i = i + 1;
			k = k + 1;
		}
		while (j < rn) {
			arr[k] = right[j];
			j = j + 1;
			k = k + 1;
		}
	}

	public static void main(String[] args) {
		int[] arry = { 5, 2, 1, 8, 6, 7 };
		MergeSort.mergersort(arry);
		System.out.println("----after merge sort---: ");

		for (int a : arry)
			System.out.println(a);
	}

}