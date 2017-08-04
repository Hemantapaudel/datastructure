package arrays_dynamicprograms;

public class KnapsackProblemDynamic {
	
	
	public static int  knapsack(int []weight, int []value, int total){
		
		int [][]T = new int[weight.length+1][total+1];
		
		// if total weight is zero then values as well be zero , I.e. first row and column both are zeros 
		for(int i =1; i< T.length;i++){
			for(int j = 1; j< T[0].length;j++){
				//Total weight (J) is less then selecting weight, then just copy the upper value
				if(weight[i-1] - j <0){
					T[i][j] = T[i-1][j];
				}else{
					T[i][j] =  Math.max( value[i-1] + T[i-1][j-weight[i-1]], T[i-1][j]);
				}
			}
		}
		return T[value.length][total];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
