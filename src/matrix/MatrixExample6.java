package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Maximum size square sub-matrix with all 1s
 * 
 * 1) Construct a sum matrix S[R][C] for the given M[R][C].
     a)	Copy first row and first columns as it is from M[][] to S[][]
     b)	For other entries, use following expressions to construct S[][]
         If M[i][j] is 1 then
            S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
         Else 
            S[i][j] = 0
2) Find the maximum entry in S[R][C]
3) Using the value and coordinates of maximum entry in S[i], print 
   sub-matrix of M[][]
 *
 */
public class MatrixExample6 {

	public static void main(String[] args) {
		
		
		System.out.println(MatrixExample6.decode("","2101").size());
		
		MatrixExample6.collapseString("GGGGGrrt");
		
		 int M[][]  = { {0,1,1,0,1},
				 		{1,1,0,1,0},
				 		{0,1,1,1,0},
				 		{1,1,1,1,0},
				 		{1,1,1,1,1},
				 		{0,0,0,0,0}
		    		  };
		 
		 int S[][] = new int[M.length][M[0].length];
		 // copy first row and column into s
		 int row = M.length;
		 int column = M[0].length;
		 int i,j;
		 for(i =0;i< column;i++){
			 S[0][i] = M[0][i];
		 }
		 for(i =0;i< row;i++){
			 S[i][0] = M[i][0];
		 }	 
		 
		 for(i = 1; i< row;i++){
			 for(j=1;j< column ; j++){
				 if(M[i][j] ==1){
					 int min =min(S[i][j-1] , S[i-1][j], S[i-1][j-1] );
					// System.out.println(" min "+ min);
					 S[i][j] = min +1;
				 }else{
					 S[i][j] =0;
				 }
			 }
		 }
		 // find the max element in S
		 int max = Integer.MIN_VALUE;
		 int  max_i = 0, max_j = 0;
		 for(i = 0; i< row;i++){
			 for(j=0;j< column ; j++){
				if(S[i][j] > max){
					max = S[i][j];
					max_i =i;
					max_j = j;
				} 
			 }
		}
		
		 
		 for(i = max_i- max+1; i<= max_i;i++){
			 System.out.println();
			 for(j= max_j - max +1 ;j <= max_j ; j++){
				System.out.print( M[i][j] +" ");
			 }
			 System.out.println();
		} 
	}
	
	static void print(int arr[][]){
		int i,j;
		for (i = 0; i < arr.length; i++) {
			System.out.println();
			System.out.print("[");
			for (j = 0; j < arr[0].length; j++) {
				System.out.print(" "+arr[i][j]);
			}
			System.out.print("]");
		}
	}
	
	public static int min(int a, int b, int c)
		{
		  int m = a;
		  if (m > b) 
		    m = b;
		  if (m > c) 
		    m = c;
		  return m;
		}
	
	/*
	 * Complete the function below.
	 */

	static String collapseString(String input) {

		if (input == null || input.isEmpty()) {
			return input;
		}
		char[] arr = input.toCharArray();
		int count = 1;
		char previouschar = arr[0];
		StringBuffer buffer = new StringBuffer();
		for (int i = 1; i < arr.length; i++) {
			if (previouschar == arr[i]) {
				count++;
			} else {
				buffer.append(count).append(previouschar);
				previouschar = arr[i];
				count = 1;
			}
		}
		buffer.append(count).append(previouschar);
		System.out.println(buffer.toString());
		return buffer.toString();
	}

	
	static public Set<String> decode(String prefix, String input) {
		Set<String> set = new HashSet<String>();
		if (input.length() == 0) {
			set.add(prefix);
			return set;
		}

		if (input.charAt(0) == '0')
			return set;

		set.addAll(decode(prefix + (char) (input.charAt(0) - '1' + 'a'),
				input.substring(1)));
		if (input.length() >= 2 && input.charAt(0) == '1') {
			set.addAll(decode(
					prefix + (char) (10 + input.charAt(1) - '1' + 'a'),
					input.substring(2)));
		}
		if (input.length() >= 2 && input.charAt(0) == '2'
				&& input.charAt(1) <= '6') {
			set.addAll(decode(
					prefix + (char) (20 + input.charAt(1) - '1' + 'a'),
					input.substring(2)));
		}
		return set;
}

	

}
