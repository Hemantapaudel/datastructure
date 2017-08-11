package arrays_dynamicprograms.basic;

public class MinimumNumberOfJumpsToReachEnd {

	public static  int minJumps(int arr[]) {

		int[] jumps = new int[arr.length];
		int[] result = new int[arr.length];
		jumps[0] = 0;
		result[0] = 0;

		// start from second index
		for (int i = 1; i < arr.length; i++) {
			jumps[i] = Integer.MAX_VALUE - 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (i <= j + arr[j]) {
					if (jumps[i] > jumps[j] + 1) {
						jumps[i] = jumps[j] + 1;
						result[i] = j;
					}
				}
			}
		}
	 return jumps[arr.length-1];
	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(minJumps(arr));
	}

}
