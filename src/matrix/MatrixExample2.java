package matrix;

/**
 * 
 * Search in a row wise and column wise sorted matrix
 * Given an n x n matrix and a number x, find position of x in the matrix if it is present in it.
 * Else print “Not Found”. In the given matrix, every row and column is sorted in increasing order.
 *  The designed algorithm should have linear time complexity.
 *  
 *  Example :
 *  
 *   Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
 * Output : Found at (2, 1)
 * 
 */
public class MatrixExample2 {
	public static void main(String[] args) {
	   int arr[][]  = { {10, 20, 30, 40},
			   		    {15, 25, 35, 45},
			   		    {27, 29, 37, 48},
			   		    {32, 33, 39, 50}};
	
	   MatrixExample2.findX(arr, 35);
	   MatrixExample2.findXInMatrix(arr, 35);
	   
	}
	

	
  public static void findXInMatrix(int[][]matrix ,int x){
		int row = 0;
		int column = matrix[0].length-1;
		
		while(row < matrix.length-1 && column >= 0){
			
			System.out.println(matrix[row][column]);
			if(matrix[row][column] == x){
				System.out.println("row, column "+ row + " , "+ column);
				return;
			}
			if(matrix[row][column] > x){
				column--;
			}else {
				row++;
			}
		}
		System.out.println("not found");
		
	  
	}
	
  public static void  findX(int [][]matrix, int x){
		
		int row = matrix.length;
		int column = matrix[0].length;
		
		for(int i= 0;i< row;i ++){
			for(int j= 0;j< column; j++){
				System.out.println(matrix[i][j]);
				if(matrix[i][j] == x){
					System.out.println("row , column " +i+" , "+j);
					return;
				}else if(matrix[i][j] > x){
					break;
				}
			}	
		}
		System.out.println("not found");
		
	}

}
