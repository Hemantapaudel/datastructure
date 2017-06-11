package matrix;
/**
 * 
 * Print a given matrix in spiral form
 * 
 */
public class MatrixExample3 {
	public static void main(String[] args) {

		 int arr[][]  = { {1, 2, 3, 4},
		   		    {12, 13, 14, 5},
		   		    {11, 16, 15, 6},
		   		    {10, 9, 8, 7}};
		MatrixExample3.printMatrixInsprialy(arr);
	}

	static void printMatrixInsprialy(int [][]matrix){
		
		int rowStart = 0;
		int rowEnd = matrix.length-1;
		
		int columnStart =0;
		int columnEnd =matrix[0].length-1;
		
		int i =0;
		
		while( rowStart < rowEnd && columnStart < columnEnd){
			
			for(i =columnStart; i<= columnEnd;i++){
				System.out.println(matrix[rowStart][i]);
			}
			rowStart++;
			
			for(i = rowStart;i<= rowEnd; i++){
				System.out.println(matrix[i][columnEnd]);
			}
			columnEnd--;
			
			for(i = columnEnd; i >= columnStart; i--){
				System.out.println(matrix[rowEnd][i]);
			}
			rowEnd--;
			
			for( i= rowEnd; i>= rowStart; i--){
				System.out.println(matrix[i][ columnStart]);
			}
			columnStart++;
			
		}
		
	}
	
	
}
