package arrays;

import java.util.Arrays;

/**
 * 
 * Q 1. Check if array elements are consecutive??
 * 
 * If array is {5, 2, 3, 1, 4}, then the function should return true because the array has consecutive
 * numbers from 1 to 5.
 *
 */
public class CheckConsecutive {
	public static void main(String[] args) {
	
		System.out.println("Test 1 : ");
		int[] arr = { 12, 5, 25, 35, 7, 8, 10 };
		ArrayUtils.print(arr);
		System.out.println(isArrayIsConcutive(arr));
		System.out.println(isArrayIsConsecutiveUsingSorting(arr));
		System.out.println(isArrayIsConsecutiveMakingElementNegative(arr));
		
		System.out.println(" test case 2");
		int[] arr1 ={83, 78, 80, 81, 79, 82};
		ArrayUtils.print(arr1);
		System.out.println(isArrayIsConcutive(arr1));
		System.out.println(isArrayIsConsecutiveUsingSorting(arr1));
		System.out.println(isArrayIsConsecutiveMakingElementNegative(arr1));
		
		System.out.println("test case 3");
		int[] arr2 ={7, 6, 5, 5, 3, 4};
		ArrayUtils.print(arr2);
		System.out.println(isArrayIsConcutive(arr2));
		System.out.println(isArrayIsConsecutiveUsingSorting(arr2));
		System.out.println(isArrayIsConsecutiveMakingElementNegative(arr2));
	}

	
	/**
	 * 
	 * using Visitor array
	 */
	private static boolean isArrayIsConcutive(int[] arr) {
		int min = ArrayUtils.getMin(arr);
		int max = ArrayUtils.getMax(arr);
		
		//if array is consecutive then it will be ==>> max-min +1 = Size of array
		if (max - min + 1  != arr.length){
			return false;
		}

		//creating visitor array  with false values
		boolean[] visitors = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			visitors[i] = false;
		}
		// arr[i]- min will be alway array index
		for (int i = 0; i < arr.length; i++) {
			
				int index = arr[i] - min;
				if (visitors[index] != false) {
					return false;
				}
				visitors[index] = true;
		}
		return true;
	}

	/**Method 2
	 * using  sorting technique  
	 * @param arr
	 * @return
	 */
	public static boolean isArrayIsConsecutiveUsingSorting(int []array){
		int [] arr = Arrays.copyOf(array, array.length);
		
		Arrays.sort(arr);
		for(int i=0;i< arr.length-1;i=i+2){
			if(arr[i]-arr[i+1] ==1 || arr[i+1]-arr[i] ==1){
				continue;
			}else{
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
	/**
	 * Mark visited array elements as negative
	 */
	public static boolean isArrayIsConsecutiveMakingElementNegative(int []array){
		int []arr = Arrays.copyOf(array, array.length);
		int min = ArrayUtils.getMin(arr);
		int max = ArrayUtils.getMax(arr);
		
		//if array is consecutive then it will be ==>> max-min +1 = Size of array
		if (max - min + 1  != arr.length){
			return Boolean.FALSE;
		}
		
		for(int i=0;i<arr.length;i++){
			//get +ve index
			int index = Math.abs(arr[i])-min;
            /// if the value at index  is negative then there is repetition
            if(arr[index]<0){
            	return Boolean.FALSE;
            }
            arr[index]=- arr[index];
		}
		return Boolean.TRUE;
		
		
		
	}
	
	
}
