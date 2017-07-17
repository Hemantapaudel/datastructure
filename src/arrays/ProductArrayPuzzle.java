package arrays;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class ProductArrayPuzzle {

	/**
	 * Given an array arr[] of n integers, construct a Product Array prod[] 
	 * (of same size) such that prod[i] is equal to the product of all the elements of arr[] 
	 * except arr[i]. Solve it without division operator and in O(n).
	 * 
	 * Example:
	 * arr[] = {10, 3, 5, 6, 2}
	 * prod[] = {180, 600, 360, 300, 900}
	 * 
	 */
	private static int[]productArrayPuzzleUsingLeftAndRightArray(int[] arr){
		int []left = new int[arr.length];
		int []right = new int[arr.length];
		int []product = new int[arr.length];
		
		left[0]  = 1;
		right[arr.length-1]  = 1;
		for(int i=1, j= arr.length-2 ; i< arr.length;i++,j--){
			left[i] = left[i-1] * arr[i-1];
			right[j] = right[j+1] * arr[j+1];
		}
	
		for(int k=0;k< arr.length;k++)
			product[k] = left[k]* right[k];
		return product;
		
	}

	private static int[]productArrayPuzzleBestSolution(int[] arr){
		int []product = new int[arr.length];
		product[arr.length-1] =1;
		
		int temp =1;
		/* In this loop, temp variable contains product of elements on left side excluding arr[i] */
		for(int i =0;i< arr.length;i++){
			product[i] = temp;
			temp = temp* arr[i];
		}
		
		
		/* Initialize temp to 1 for product on right side */
        temp = 1;
 
        /* In this loop, temp variable contains product of
           elements on right side excluding arr[i] */
        
        for(int i = arr.length-1; i>=0; i--){
        	product[i] = product[i] * temp;
        	temp = temp * arr[i];
        }
        return product;
	}

	/**
	 * using divide the product using same element and assign to result
	 */
	private static int[] productArrayPuzzle(int []arr){
		
		int []productPuzzle = new int[arr.length];
		IntBinaryOperator binaryOperator = (first , second) -> first * second;
		int product = Arrays.stream(arr).reduce(1, binaryOperator);
		
		for(int i=0;i< arr.length ;i++){
			productPuzzle[i] = product/arr[i];
		}
		return productPuzzle;
	}
	
	public static void main(String[] args) {

		int arr[] = {10, 3, 5, 6, 2};
		ArrayUtils.print(arr);
		ArrayUtils.print(productArrayPuzzle(arr));
		ArrayUtils.print(productArrayPuzzleUsingLeftAndRightArray(arr));
		ArrayUtils.print(productArrayPuzzleBestSolution(arr));
		
		
	}

}
