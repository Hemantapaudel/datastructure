package arrays;


/**
 *
 * Given an array of positive numbers, find the maximum sum of a subsequence with the 
 * constraint that no 2 numbers in the sequence should be adjacent in the array.
 *  So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15
 * (sum of 3, 5 and 7).Answer the question in most efficient way.
 *
 */
public class LargestSumSuchThatNoTwoElementsAreAdjacent {

	
	/**
	 * Algorithm: 
	 * Loop for all elements in arr[] and maintain two sums incl and excl
	 *  where incl = Max sum including the previous element 
	 *  and excl = Max sum excluding the previous element.
	 */
	
	public static void largestSumNOnContiguousElement(int arr[]){
		
		int includeMax = arr[0];
		int excludeMax = 0;
		int exclude_new =0;
		
		for(int i =1;i< arr.length;i++){
			exclude_new = Math.max(excludeMax, includeMax);
			includeMax = excludeMax + arr[i];
			excludeMax = exclude_new;   
		}
		if(excludeMax > includeMax){
			System.out.println(excludeMax);
		}else{
			System.out.println(includeMax);
		}
	}
	
	
	public static void main(String[] args) {
		largestSumNOnContiguousElement( new int[]{-1,-2,4,-2,1,5,-1});
	}

}
