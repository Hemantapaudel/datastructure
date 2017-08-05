package arrays_dynamicprograms.basic;

import java.util.Arrays;
import java.util.stream.IntStream;

import arrays.ArrayUtils;

public class MaximumLengthIncreasingSubsequence {

	
	private static int getMLS(int []arr){
		ArrayUtils.print(arr);
		int []mls= new int[arr.length];
		// initialize with one
		IntStream.range(0, arr.length).forEach( index -> mls[index] =1);
		
		for(int i =1; i< arr.length;i++){
			for(int j =0; j < i;j++){
				if(arr[i] > arr[j]  && mls[i] < mls[j]+1 ){
					mls[i] = mls[j]+1;
				}
			}
		}
		
		ArrayUtils.print(mls);
		return Arrays.stream(mls).max().getAsInt();
	}
	
	
	
	public static void main(String[] args) {

		 int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		 System.out.println(getMLS(A));
		
	}

}
