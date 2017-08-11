package arrays_dynamicprograms.basic;

import arrays.ArrayUtils;

public class LongestCommonSubStringOfTwoString {

	public static int LC_substring_Dynamic(char[]input1, char input2[]){
		
		int [][]M = new int[input1.length+1][input2.length+1];
		// initialize first row and column with zero		
	   //  M[0][0] = 0;
		
		
		int max =0;
		for(int i=1; i < M.length; i++){
			for(int j=1; j < M[0].length; j++){
								
				// if both are match, copy diagonal value and add 1 on the same
				if(input1[i-1] == input2[j-1]){
					M[i][j] = M[i-1][j-1] + 1;
				}else{
					M[i][j] =0;
				}
				if(max < M[i][j]){
					max = M[i][j];
				}
			}	
		}
		ArrayUtils.print(M);
		return max;
		
	}
	public static void main(String[] args) {

		char []arr1 = {'a','b','c','d','a','f'};
		char [] arr2 = {'a','c','d','a','f'};
		
		System.out.println(LC_substring_Dynamic(arr1,arr2));	
		
	}

}
