package arrays;

import arrays.sortings.HeapSort;

public class KLargestElementsInArrays {

	/**
	 * 	O( N + kLogN)
	 */
	public static void kLargestElement(int arr[], int k){
		//create max heap
		int n = arr.length;
		for(int i= n/2-1;i>=0;i--){
			HeapSort.heapify(arr, n, i);
		}
		
		// One by one extract k elements from heap
		 for (int i=n-1; i>= n-k; i--){
	            // Move current root to end
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;
	 	           
	            // call max heapify on the reduced heap
	            HeapSort.heapify(arr, i, 0);  
	        }	
			 ArrayUtils.print( arr, n-k, n-1);
	}
	
	
	public static void main(String[] args) {
		int []arr = {1, 23, 12, 9, 30, 2, 50} ;
		kLargestElement(arr,3);

	}

}
