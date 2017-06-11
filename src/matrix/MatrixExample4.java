package matrix;


/**
 * 
 * A Boolean Matrix Question
 * 
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell 
 * mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.
 * 
 */
public class MatrixExample4 {
	public static void main(String[] args) {
		
		//METHOD 1 : using temporary array for row and column
		 boolean arr[][]  = { {true, false, false, false},
		   		    		  {true, false, false, true},
		   		    		  {false, false, false, false},
		   		    		  {false, false, false, false}};
		 MatrixExample4.modifyUsingTempArray(arr);
		 MatrixExample4.print(arr);
		 
		 
		 
		 
	}
	
	static public void modifyUsingTempArray(boolean arr[][]) {
		boolean[] row = new boolean[arr.length];
		boolean[] column = new boolean[arr[0].length];

		int i = 0, j = 0;
		for (i = 0; i < row.length; i++)
			row[i] = false;
		for (i = 0; i < column.length; i++)
			column[i] = false;
		
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == true) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		/*
		 * Modify the input matrix mat[] using the above constructed row[] and
		 * column[] arrays
		 */
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[0].length; j++) {
				if (row[i] == true || column[j] == true) {
					arr[i][j] = true;
				}
			}
		}
	}
	
	static void print(boolean arr[][]){
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
	
}
