package arrays_dynamicprograms.basic.knapsack;


public class SubsetSumProblem {
	
	
	public static boolean subsetsum(int [] input, int total){
		
		boolean [][]M = new boolean[input.length+1][total+1];
		// for sum zero, it is always true 
		for(int i =0; i< M.length; i++){
			M[i][0]= true;
		}
		
		
		for(int i =1; i< M.length; i++){
			for(int j =1; j< M[0].length;j++){
			  
				// if total is less than input value then copy the i-1th rows
				boolean isTotalLessThanInputValue = input[i-1] - j > 0;
				if(isTotalLessThanInputValue){
					M[i][j] = M[i-1][j];
				}else{
					M[i][j] =  M[i-1][j] || M[i-1][j - input[i-1]];
				}
				
				
			}
			//System.out.println( Arrays.toString(M[i]));
		}
		 return M[input.length][total];
		
		
	}
	
	
	
	public static void main(String[] args) {
		int arr1[] = {2, 3, 7, 8};
        System.out.print(subsetsum(arr1, 11));
	}
}
