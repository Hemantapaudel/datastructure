package arrays;

/**
 * 
 * Given an array arr[] of integers, find out the difference between any two elements such
 *  that larger element appears after the smaller number in arr[].
 *  Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 
 *  (Diff between 10 and 2).
 *  
 *   If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
 *
 */
public class MaximumDiffrence {

	static void maxDiff(int arr[]){
		
		int max_diff = arr[1] -arr[0];
		int minElement = arr[0];
		
		int current_diff =0;
		for(int i =1;i < arr.length; i++){
			// find current and min_element different
			current_diff = arr[i] - minElement;
			if(current_diff > max_diff){
				max_diff = current_diff;
			}
			if(arr[i] < minElement){
				minElement = arr[i];
			}
		}
		System.out.println(" max diff = "+ max_diff);
		
		
		
	}
	
	public static void main(String[] args) {

		int arr[] = {1, 2, 90, 10, 110};
		maxDiff(arr);
		
	}

}
