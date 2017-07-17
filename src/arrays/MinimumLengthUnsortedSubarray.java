package arrays;

public class MinimumLengthUnsortedSubarray {

	public static void main(String[] args) {

		int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		int left = 0;
		int right = arr.length - 1;

		// Scan from left to right and find the first element which is greater
		// than the next element
		for (; left < arr.length - 1; left++) {
			if (arr[left] > arr[left + 1]) {
				break;
			}
		}
		System.out.println(left);
		// Scan from right to left t and find the first element which is smaller
		// than the next left element
		for (; right > 0; right--) {
			if (arr[right - 1] > arr[right]) {
				break;
			}
		}
		System.out.println(right);

		int lowerIndex = left;
		int upperIndex = right;

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = lowerIndex; i <= upperIndex; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("Min in subarray::" + min + " Max in Sub array::"+ max);

		//finding lower index
		int firstArrayUpperBound = left-1;
		while(firstArrayUpperBound >=0 && arr[firstArrayUpperBound] > min){
			firstArrayUpperBound = firstArrayUpperBound-1;
		}
		left = firstArrayUpperBound+1;
		
		int secondArrayLowerBound = right+1;
		while(secondArrayLowerBound <= arr.length && arr[secondArrayLowerBound] < max){
			secondArrayLowerBound = secondArrayLowerBound+1;	
		}
		right = secondArrayLowerBound -1;
		
		System.out.println("Sub array is  lowerIndex=:" + left + "  right = " + right);
		ArrayUtils.print(arr);
		ArrayUtils.print(arr, left, right);
		
	}

}
