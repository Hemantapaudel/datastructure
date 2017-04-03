package arrays.sortings;

/**
 * BASE ON DEVIDE AND CONQUER PARADIGM 1. let right most of element is pivot
 * elements. 2. less than pivot element are in left and larger is in right side
 * 3. do recursive call for first left sub array and then right sub array
 */
public class QuickSort {

	public static void quickSort(int[] arr, int firstIndex, int LastIndex) {
		if (firstIndex < LastIndex) {
			int q = partition(arr, firstIndex, LastIndex);
			// quick sort for left sub array
			quickSort(arr, firstIndex, q - 1);
			// right sub array
			quickSort(arr, q + 1, LastIndex);
		}
	}

	public static int partition(int[] arr, int p, int r) {
		// let right most element/ last element is pivot.
		// this method move
		// exchange if arr[j] is < pivot element

		int pivot = arr[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (arr[j] <= pivot) {
				i = i + 1;
				// swap(arr[i],arr[j]);
				int a = arr[i];
				arr[i] = arr[j];
				arr[j] = a;
			}
		}
		i = i + 1;

		// swap(arr[r],arr[i+1]);
		int a = pivot;// arr[r];
		arr[r] = arr[i];
		arr[i] = a;
		return i;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 1, 3, 8, 7, 9, 4, 6 };
		int q = 0;// starting index
		int r = arr.length - 1;// last index
		QuickSort.quickSort(arr, q, r);
		for (int a : arr)
			System.out.print(a + "  ");
	}
}
