package arrays;


public class BinarySearch {

	public static int binarySearch(int[]arr,int lowerIndex, int upperIndex,int key){
		if(lowerIndex>upperIndex){
			return -1;
		}
		int mid = (lowerIndex+ upperIndex)/2;
		if(key == arr[mid]){
			return mid;
		}		
		if(key >arr[mid]){
			return binarySearch(arr, mid+1, upperIndex, key);
		}
		return binarySearch(arr, lowerIndex, mid-1,	 key);
	}



	public static void main(String[] args) {
		int [] arr = {1,3,4,6,9,17,21,25,28,36,39,45};
		System.out.println(binarySearch(arr, 0, arr.length-1, 21));
	}
	
}
