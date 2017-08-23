package arrays.sortings;

import arrays.ArrayUtils;

public class WaveFormSorting {

	/**
	 *  O(N^2)
	 */
	public static void waveSortByMergeSort(int []arr){
		MergeSort.mergersort(arr);
		for(int i=0; i< arr.length-1 ; i= i+2){
		
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}
	}
	
	
	/**
	 *  O(N)
	 */
	public static void waveSort(int arr[]){
		
		for(int i =0; i < arr.length;i = i+2){
			// If current even element is smaller than previous
	        if (i>0 && arr[i-1] > arr[i] ){
	        	int temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
	        }
	        // If current even element is smaller than next
			if (i < arr.length - 1 && arr[i] < arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {

		int arr[] = {10, 5, 6, 3, 2, 20, 100, 80};
		waveSortByMergeSort(arr);
		ArrayUtils.print(arr);
		
		int arr2[] = {10, 5, 6, 3, 2, 20, 100, 80};
		waveSort(arr2);
		ArrayUtils.print(arr2);
		
		
	}

}
