package arrays;

public class FindSmallestPositiveNumberMissingElement {

	public static void main(String[] args) {
		// int arr[] = { 0, 1, 2, 4, -10, -20 };
		// int arr[] ={482,484};
		//int arr[] = { 1 };
		int arr[] = { 2,1,3,4,6,5 };
		int missing = findMissing(arr);
		System.out
				.println("The smallest positive missing number is " + missing);
	}

	static int findMissing(int arr[]) {
		int index;
		int shift = segregate(arr);
		//this is for all positive and no missing number in an array
		int max = Integer.MIN_VALUE;
		for (int i = shift; i < arr.length; i++) {
			index = Math.abs(arr[i]) - 1 + shift;
			if (max < arr[i]) {
				max = arr[i];
			}
			if (index >= 0 && index < arr.length && arr[index] > 0) {
				arr[index] = -arr[index];
			}
		}
		for (int i = shift; i < arr.length; i++) {
			if (arr[i] > 0) {
				return (i + 1) - shift;
			}
		}
		return max+1;
	}

	static int segregate(int arr[]) {
		int j = 0, i;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] <= 0) {
				int temp;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		return j;
	}
}
