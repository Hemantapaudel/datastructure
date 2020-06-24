package arrays.rotation;

import java.util.Arrays;

public class SearchElementInSortedAndRotatedArray {
	
	
	
	public  static void findMinOnRotatedArray(int []arr){
		
		int pivotIndex = findPivot(arr, 0, arr.length-1);
		System.out.println("pivot is :"+pivotIndex);
		 // find pivot index
		 if(pivotIndex > 0){
			 System.out.println("Min value "+ arr[pivotIndex+1]);
		 }else{
			 //array is not rotated
			 System.out.println("Min value is "+ arr[0]);
		 }
	}

	private static int findPivot(int []arr, int low, int high){
		
		// No pivot found
	    if (high < low)  
	            return -1;
		if(low == high)
			return high;
		
		int mid = (low +high)/2;
		
		if(mid < high &&   arr[mid] > arr[mid +1] )// this means mid is pivot point
			return mid;
		
		if( mid > low && arr[mid] < arr[mid-1])
			return mid-1;
		// if lower index is higher value than mid value we need to search on first half 
		if(arr[low] >= arr[mid]){
			return findPivot(arr, low, mid-1);
		}else{
			return findPivot(arr,mid+1, high);
		}
		
	}

	private static int searchOnPivotedArray(int []arr, int key){
		
		int pivotIndex = findPivot(arr, 0, arr.length-1);
		if(pivotIndex < 0){
			// array is not rotated search on whole array
		    return	Arrays.binarySearch(arr, key);
		}
		
		if(key == arr[pivotIndex]){
			return pivotIndex;
		}
		
		if(key >= arr[0]){
			return Arrays.binarySearch(arr, 0, pivotIndex-1, key);
		}
		return Arrays.binarySearch(arr, pivotIndex+1, arr.length-1, key);	
	}
	
	
	
	
	
	public static void main(String[] args) {
		
     findMinOnRotatedArray(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3});
     findMinOnRotatedArray(new int[]{ 1, 2, 3,5, 6, 7, 8, 9, 10});
     
     
      int index = searchOnPivotedArray(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3}, 9);
      
      System.out.println("Found at Index :"+ index);
     
	}

}
