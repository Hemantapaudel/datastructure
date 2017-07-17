package arrays;

public class CountNumberOfOccurrences {

	private static  int getCount(int []arr, int x){
		
		int index = binarySearch(arr, 0, arr.length, x);
		if(index ==-1)
			return 0;
		
		int lowerIndex = index;
		for(; lowerIndex >= 0 && arr[lowerIndex]==x;lowerIndex--);
		lowerIndex++;
		
		int upperIndex = index;
		for(; upperIndex <arr.length && arr[upperIndex]==x;upperIndex++);
		upperIndex--;
		
		return upperIndex-lowerIndex +1;
		
	}
	
	private static int binarySearch(int[]arr, int low, int high,int x){
		
		if(low <=high){
			int mid = (low+high)/2;
			if(arr[mid] == x){
				return mid;
			}else if(arr[mid] > x){
				return binarySearch(arr, low, mid-1, x);
			}else{
				return binarySearch(arr, mid-1, high, x);
			}
		}else{
			return -1;
		}
		
	}
	
	public static void main(String[] args) {

		int arr[] = {1, 2, 2, 3, 3, 3, 3};
		System.out.println(getCount(arr, 1));
	}

}
