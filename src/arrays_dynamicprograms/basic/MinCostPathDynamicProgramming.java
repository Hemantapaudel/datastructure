package arrays_dynamicprograms.basic;

import arrays.ArrayUtils;

public class MinCostPathDynamicProgramming {
	
	//creating copy of the matrix to calculate total cost (TC)
	//M -> row index
	//N  -> column index
	public static int minCost(int [][] COST, int m , int n){
		
		int TC [][] = new int[m+1][n+1];
		 TC[0][0] = COST[0][0];
		
		 /* Initialize first column of total cost(tc) array */
	     for (int i = 1; i <= m; i++)
	        TC[i][0] = TC[i-1][0] + COST[i][0];
	     
	     /* Initialize first row of total cost(tc) array */
	     for (int i = 1; i <= n; i++)
	        TC[0][i] = TC[0][i-1] + COST[0][i];
	     
	     
	     
	     for (int i = 1; i <= m; i++)
	         for (int j = 1; j <= n; j++){
	        	 // if diagonal travel also allow
	        	 //TC[i][j] = min( TC[i-1][j-1],  TC[i][j-1], TC[i-1][j]) + COST[i][j];
	        	 
	        	 // only allow horizontal and vertical travel
	        	 TC[i][j] = Math.min( TC[i][j-1], TC[i-1][j]) + COST[i][j];
	        	 
	         }
	     
	     return TC[m][n];
	}
	
	/*private static int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }*/
	

	
	// find the maximum distance from (x,y) to (m,n) point
	// now you can move horizontal, diagonal and vertical
	public static int minDistance(int cost[][], int x, int y, int m, int n){
		
		ArrayUtils.print(cost);
		// add all cost for x from y column
		for(int i = y+1 ; i <=n; i++){
			cost[x][i] = cost[x][i-1]+ cost[x][i];
		}
		
		for(int j = x+1; j<=m; j++){
			cost[j][y] = cost[j-1][y]+ cost[j][y];
		}
		System.out.println();
		ArrayUtils.print(cost);

		for(int i = x+1 ; i <= m ; i++){
			for(int j = y+1; j <= n; j++){
				cost[i][j] = cost[i][j] + 
						Math.min(cost[i][j-1], cost[i-1][j]);
			}
		}
		System.out.println("===============");
		ArrayUtils.print(cost);
		return cost[m][n];
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		  int cost[][] = {
				  		  {1,3,5,5},
				  		  {4,2,1,7},
				          {4,3,2,3}};
		  
	      int result = minCost(cost, 2, 3);  
	      
	      System.out.println(result);
	      
	      System.out.println(minDistance(cost, 1, 1, 2, 3));

	}

}
