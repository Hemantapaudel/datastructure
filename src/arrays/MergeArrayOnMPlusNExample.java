package arrays;

/**
 * 
 * Merge an array of size n into another array of size m+n
 * There are two sorted arrays. First one is of size m+n containing only m elements. 
 * Another one is of size n and contains n elements. Merge these two arrays into the first 
 * array of size m+n such that the output is sorted.
 */
public class MergeArrayOnMPlusNExample {
	
	/*
	 * Algorithm:
	 * 
	 *	Let first array be mPlusN[] and other array be N[]
	 * 1) Move m elements of mPlusN[] to end.
     * 2) Start from nth element of mPlusN[] and 0th element of N[] and merge them into mPlusN[].
	 */
	
	
	private void moveElementAtLast(int arr[]){
		int moveToIndex = arr.length-1 ;
		for(int index = arr.length -1;index >=0;index--){
			if(arr[index] != -1){
				arr[moveToIndex] = arr[index];
				moveToIndex--;
			}
		}
		
	}
	
	
	private void mergeTwoArrayIntoOne(int[] mPluseN , int []arr2){
		System.out.println("Given arrays : mplusN");
		ArrayUtils.print(mPluseN);
		System.out.println("Given arrays : arr2");
		ArrayUtils.print(arr2);
		
		moveElementAtLast(mPluseN);
		System.out.println("After moveelement into end position, NPlusM");
		ArrayUtils.print(mPluseN);
		
		
		int first = arr2.length ;
		int second = 0;
		int result =0;
		while(first < mPluseN.length && second < arr2.length){
			if(mPluseN[first] < arr2[second]){
				mPluseN[result] = mPluseN[first];
				first++;
			}else{
				mPluseN[result] = arr2[second];
				second++;
			}
			result++;
		}
		
		if(first  !=  mPluseN.length-1){
			while(first < mPluseN.length){
				mPluseN[result] = mPluseN[first];
				first++;
				result++;
			}
		}
		if(second  !=  arr2.length-1){
			while(second < arr2.length){
				mPluseN[result] = arr2[second];
				second++;
				result++;
			}
		}
		System.out.println("Result,  NPlusM");
		ArrayUtils.print(mPluseN);
		
		
	}
	
	
	public static void main(String[] args) {
		 int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
	     int arr2[] = {5, 7, 9, 25};
	     
	     MergeArrayOnMPlusNExample mergeArray = new MergeArrayOnMPlusNExample();
	     mergeArray.mergeTwoArrayIntoOne(mPlusN, arr2);
	     
	}

}
