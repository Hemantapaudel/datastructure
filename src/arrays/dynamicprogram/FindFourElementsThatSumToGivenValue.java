package arrays.dynamicprogram;

import java.util.Arrays;

/**
 *
 * Given an array of integers, find all combination of four elements in the
 * array whose sum is equal to a given value X. For example, if the given array
 * is {10, 2, 3, 4, 5, 9, 7, 8} and X = 23, then your function should print “3 5
 * 7 8” (3 + 5 + 7 + 8 = 23).
 *
 */
public class FindFourElementsThatSumToGivenValue {

	/**
	 * Method 1,
	 * 
	 * Time Complexity: O(n^4)
	 */
	public static void findFourElements(int[] arr, int sum) {
		int length = arr.length;
		for (int i = 0; i < length - 3; i++) {

			for (int j = i + 1; j < length - 2; j++) {

				for (int k = j + 1; k < length - 1; k++) {

					for (int l = k + 1; l < length; l++) {

						if (arr[i] + arr[j] + arr[k] + arr[l] == sum)
							System.out.println("[" + arr[i] + ", " + arr[j]
									+ " ," + arr[k] + "," + arr[l] + "]");
					}
				}
			}
		}
	}

	/**
	 * Method 2 : Sorting and finding the 4 element Time Complexity: O(n^3)
	 */
	public static void findFourElementSetHavingGivenSum(int[] arr, int sum) {
		// sorting the given element
		Arrays.sort(arr);
		int length = arr.length;
		for (int i = 0; i < length - 3; i++) {
			for (int j = i + 1; j < length - 2; j++) {
				int left = j + 1;
				int right = length - 1;
				while (left < right) {
					if (arr[i] + arr[j] + arr[left] + arr[right] == sum) {
						System.out.println("[" + arr[i] + ", " + arr[j] + " ,"
								+ arr[left] + "," + arr[right] + "]");
						left++;
						right--;
					} else if (arr[i] + arr[j] + arr[left] + arr[right] > sum) {
						right--;
					} else {
						left++;
					}
				}
			}
		}
	}

	/**
	 * Mehtod 3
	 * 
	 * create all possible pair (N * (N-1)/2)
	 * 
	 */

	public static void findFourElementByBestSolution(int[] arr, int X) {

		int length = arr.length;
		PairElement[] aux = new PairElement[length * (length - 1) / 2];
		int k = 0;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				 aux[k] = new PairElement(arr[i],arr[j]);
				 System.out.println(aux[k]);
				k++;
			}
		}
		
		Arrays.sort(aux); 

		int left = 0;
		int right = aux.length-1;
		
		while(left < right){
			
			if(aux[left].sum + aux[right].sum ==X  && ! isCommon(aux[left], aux[right])){
				System.out.println( aux[left].toString()+ aux[right].toString());
				left++;
				right--;
			}else if(aux[left].sum + aux[right].sum > X){
				right--;
			}else{
				left++;
			}
		}
	}
	
	
	// Function to check if two given pairs have any common element or not
	public static boolean isCommon( PairElement first,  PairElement second){
		
		if(first.a == second.a 
				|| first.a == second.b
				|| first.b == second.a
				|| first.b == second.b)
	        return true;
	    return false;
	}
	

	public static void main(String[] args) {
		int A[] = { 10, 20, 30, 40, 1, 2 };
		int X = 91;
		findFourElements(A, X);
		findFourElementSetHavingGivenSum(A, X);
		findFourElementByBestSolution(A, X);
	}

}

class PairElement implements Comparable<PairElement> {
	int a;
	int b;
	int sum;

	public PairElement(int a, int b) {
		this.a = a;
		this.b = b;
		this.sum = a + b;
	}

	@Override
	public String toString() {
		return "(" + a + "," + b + ") ";
	}

	@Override
	public int compareTo(PairElement pair) {
		return this.sum - (pair.a + pair.b);
	}
}
