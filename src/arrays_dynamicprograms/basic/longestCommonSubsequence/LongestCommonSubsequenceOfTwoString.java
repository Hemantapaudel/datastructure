package arrays_dynamicprograms.basic.longestCommonSubsequence;


public class LongestCommonSubsequenceOfTwoString {

	
	public static int LCS_Recursive(char[]str1, char[]str2, int i,int j){
		
		if(str1.length == i || str2.length ==j){
			return 0;
		}	
		if(str1[i] == str2[j]){
			return 1 + LCS_Recursive(str1, str2, i+1, j+1);
		}
		return Math.max(LCS_Recursive(str1, str2, i+1, j), LCS_Recursive(str1, str2, i, j+1));
		
	}
	
	
	public static int LCS_Dynamic(char[]arr1, char arr2[]){
				
		int [][]M = new int[arr1.length+1][arr2.length+1];
		
		int max =0;
		for(int i=1; i < M.length; i++){
			for(int j=1; j < M[0].length; j++){
				
				// if any one string is zero length then total max subsequence will be zero
				if (i == 0 || j == 0)
			         M[i][j] = 0;
				
				// if both are match, copy diagonal value and add 1 on the same
				if(arr1[i-1] == arr2[j-1]){
					M[i][j] = M[i-1][j-1] + 1;
				}
				
				// if no math is found, take max of previous row or column
				else{
					M[i][j]  = Math.max(M[i][j-1], M[i-1][j]);
				}
				if(max < M[i][j]){
					max = M[i][j];
				}
			}	
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		
		char []arr1 = {'a','b','c','d','a','f'};
		char [] arr2 = {'a','c','b','c','f'};
		
		System.out.println(LCS_Dynamic(arr1,arr2));	
		System.out.println(LCS_Recursive(arr1, arr2, 0, 0));
	}
	
	
	

}
