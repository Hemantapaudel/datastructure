package arrays.grouping;

import arrays.ArrayUtils;
import arrays.sortings.MergeSort;

public class CountTriangle {

	//Method 1. using three loop
	
	
	//Method2 : using sorting and two loop
	
	public static int printAllTriangleSet(int []arr){
		
		// sorting O(NlogN)
		MergeSort.mergersort(arr);
		
		int count =0;
		
		// fixed first two elements and search third element from j+1 to N, in such that
		// (arr[i]+ arr[j]) > arr[k]
		
		// here array is already sorted arr[i]< arr[j]< arr[k] will always valid
		for(int i =0; i < arr.length-2; i++){
			
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if ((arr[i] + arr[j]) > arr[k]) {
						ArrayUtils.print(arr, i,j,k);
						count++;
					}
				}
			}
		}		
		return count;
	}
	
	
	
	public static void main(String[] args) {
		
		 int arr[] = {10, 21, 22, 100, 101, 200, 300};
		 System.out.println(printAllTriangleSet(arr));

	}

}
