package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 * 
 * Algorithm hasArrayTwoCandidates (A[], ar_size, sum) 1) Sort the array in
 * non-decreasing order. 2) Initialize two index variables to find the candidate
 * elements in the sorted array. (a) Initialize first to the leftmost index: l =
 * 0 (b) Initialize second the rightmost index: r = ar_size-1 3) Loop while l <
 * r. (a) If (A[l] + A[r] == sum) then return 1 (b) Else if( A[l] + A[r] < sum )
 * then l++ (c) Else r-- 4) No candidates in whole array - return 0
 */
public class PairElementsasGivenSum {
	
	/**
	 * Method 1 : take one element and take the each other element and check the sum , it will take O(N^2)
	 *  
	 */
	public static void printPairElement(int []arr, int sum){
		System.out.println("Using Iterative way ");
		for(int i=0; i< arr.length-1; i++){
			for(int j=i; j< arr.length; j++){
				if(arr[i]+ arr[j] == sum){
					System.out.println("Pait element are : "+ arr[i]+" and "+arr[j]);
				}
			}			
		}
	}
	
	
	
	
	/**
	 * Method1 : we are sorting the given array, it will take O(N log N)
	 * 
	 */
	public static void printPairElementsUsingSorting(int[] arr, int sum) {
		System.out.println("Using sorting ");
		Arrays.sort(arr);
		boolean isPairFound=false;
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			if ((arr[left] + arr[right]) == sum) {
				System.out.println("sum of the pair::a[left]=" + arr[left]+ " a[right] =" + arr[right]);
				right = right - 1;
				left = left + 1;
				isPairFound = Boolean.TRUE;
				
			} else if ((arr[left] + arr[right]) > sum) {
				right = right - 1;
			} else {
				left = left + 1;
			}
		}
		if(isPairFound == Boolean.FALSE){
			System.out.println("There is no pair element which having sum "+sum);
		}
	}
	
	/**
	 * Best solution, if space is not constraints 
	 *  using set, it take O(N) 
	 */
	public static void printPairUsingSet(int []arr,int sum){
		System.out.println("Using Hashing way");
		Set<Integer> s = new HashSet<Integer>();
		for(int a : arr){
			s.add(a);
		}
		for(int a : arr){
			int x = sum -a;
			if(s.contains(x)){
				System.out.println("found pair a= "+a +"&  x= "+x);
				s.remove(a);
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("");
		int[] arr = { 12, 5, 25, 35, 7, 8, 10 };
		printPairElement(arr,60);
		printPairElementsUsingSorting(arr,60);
		printPairUsingSet(arr,60);
	}

}
