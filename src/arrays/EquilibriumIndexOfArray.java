package arrays;

import java.util.Arrays;

/**
 * 
 * Equilibrium index of an array is an index such that the sum of elements at lower indexes 
 * is equal to the sum of elements at higher indexes. For example, in an arrya A:
 * A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 * 
 * 6 is also an equilibrium index, because sum of zero elements is zero, i.e., A[0] + A[1] 
 * + A[2] + A[3] + A[4] + A[5]=0
 */
public class EquilibriumIndexOfArray {
	
	
	private static void findEquilibriumIndex(int []arr){
		
		int sum = Arrays.stream(arr).sum();
		//System.out.println(sum);
		int leftSum =0;
		
		for(int i =0; i < arr.length;i++){
			sum = sum - arr[i];//right sum for current index
			if(leftSum == sum){
				System.out.println("leftsum = "+ leftSum + " rightsum "+sum);
				System.out.println(i);
			}
			leftSum = leftSum+ arr[i];
		}
		
	}

	public static void main(String[] args) {
		int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		findEquilibriumIndex(arr);
	}

}
