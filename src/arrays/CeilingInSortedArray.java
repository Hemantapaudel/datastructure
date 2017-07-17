package arrays;

public class CeilingInSortedArray {

	/**
	 * find ceil of x in O(LogN)
	 */
	private static  int ceilSearch(int []arr, int low, int high, int x){
		if(x <= arr[low])
			return low;
		if(x > arr[high]){
			return -1;
		}
		int mid = (low+ high)/2;
		if(x == arr[mid])
			return mid;
		if(arr[mid] < x &&  x < arr[mid+1]){
			return mid+1;
		}
		if(arr[mid] > x &&  x > arr[mid-1]){
			return mid ;
		}
		
		if( x > arr[mid]){
		   return	ceilSearch(arr, mid+1, high, x);
		} 
		return ceilSearch(arr, low, mid-1, x);	
		
	}
	
	
	/**
	 * find ceil of x in O(LogN)
	 */
	private static  int floorSearch(int []arr, int low, int high, int x){
		
		if(x > arr[high])
			return high;
		
		if(x < arr[low]){
			return -1;
		}
		int mid = (low+ high)/2;
		if(x == arr[mid])
			return mid;
		
		if(arr[mid] < x &&  x < arr[mid+1]){
			return mid;
		}
		if(arr[mid] > x &&  x > arr[mid-1]){
			return mid-1 ;
		}
		
		if( x > arr[mid]){
		   return	floorSearch(arr, mid+1, high, x);
		} 
		return floorSearch(arr, low, mid-1, x);	
	}
	
	
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 8, 10, 10, 12, 19};
	       int n = arr.length;
	       int x =9 ;
	       System.out.println(ceilSearch(arr, 0, n-1, x));
	       System.out.println(floorSearch(arr,0,n-1,x));
	}

}
