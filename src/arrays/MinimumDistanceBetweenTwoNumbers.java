package arrays;

public class MinimumDistanceBetweenTwoNumbers {

	static int findMinDistance(int[] arr, int x, int y) {

		int minDiff = Integer.MAX_VALUE;
		int prev = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x || arr[i] == y) {
				prev = i;
				i++;
				break;
			}
		}
		
		for (int i = prev + 1; i < arr.length; i++) {
			if (arr[i] == x || arr[i] == y) {
				if (arr[i] != arr[prev]) {
					minDiff = Math.min(minDiff, i - prev);
					prev = i;
				} else {
					prev = i;
				}
			}
		}
		
		return minDiff;
	}

	public static void main(String[] args) {
		int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        int x = 3;
        int y = 6;
        System.out.println(findMinDistance(arr,x,y));
	}

}
