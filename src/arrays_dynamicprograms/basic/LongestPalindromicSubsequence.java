package arrays_dynamicprograms.basic;

import arrays.ArrayUtils;

public class LongestPalindromicSubsequence {

	public static int longestPalidromeRecursive(char str[], int start, int length) {
		if (length == 1) {
			return 1;
		}
		if (length == 0) {
			return 0;
		}
		// checking str[0] and str[n-1]
		if (str[start] == str[start + length - 1]) {
			return 2 + longestPalidromeRecursive(str, start + 1, length - 2);
		} else {
			return Math.max(longestPalidromeRecursive(str, start + 1, length - 1),
					longestPalidromeRecursive(str, start, length - 1));
		}
	}
	
	
	public static int longestPalidromeDynamic(char []str){
		
		int length = str.length;
		int T[][] = new int[length][length];
		for(int i =0; i < length;i++){
			T[i][i] = 1;
		}
		
		//ArrayUtils.print(T);
		
		for(int L = 2; L <= length ;L++){
			for(int i =0; i <= length -L ; i++){
				int j = i+L -1;
				if(L ==2 && str[i] ==str[j]){
					T[i][j] =2;
				}else if(str[i] ==str[j]){
					T[i][j] = 2 +  T[i+1][j-1];
				}else{
				 T[i][j] = Math.max(T[i][j-1], T[i+1][j]);
				}
			}	
			//System.out.println("===========");
			ArrayUtils.print(T);
			
		}
		return T[0][length-1];
		
	}
	

	public static void main(String[] args) {
		String str = "agbdba";
		System.out.println(longestPalidromeRecursive(str.toCharArray(), 0, str.length()));
		System.out.println(longestPalidromeDynamic(str.toCharArray()));
	}
}
 