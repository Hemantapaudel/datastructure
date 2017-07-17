package arrays.sortings;

import arrays.ArrayUtils;

public class PancakeSorting {
	
	
	private static void sort(int []arr){
		
		if (arr== null){
			return;
		}
		
		for(int currentSize = arr.length; currentSize >1; currentSize--){
			
			int maxElementIndex = findMaxElementIndex(arr,currentSize);
			
			if(maxElementIndex != currentSize-1){
				flip(arr,maxElementIndex);
				flip(arr, currentSize-1);
			}
			
		}
		ArrayUtils.print(arr);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void flip(int[] arr, int right) {
		int left =0;
		int temp;
        while (left < right)
        {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
	}



	private static int findMaxElementIndex(int[] arr, int currentSize) {
		int maxElementIndex = 0;
		for (int i =1; i < currentSize; i++)
			if(arr[maxElementIndex] < arr[i])
				maxElementIndex = i;
		return maxElementIndex;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 1, 3, 8, 7, 9, 4, 6 };
		sort(arr);
		
	}

}
