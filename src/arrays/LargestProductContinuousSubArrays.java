package arrays;

public class LargestProductContinuousSubArrays {

	public static void main(String[] args) {
		largestProdContiguousSubarray( new int[]{-1,-2,4,-2,1,5,-1});

	}

	private static void largestProdContiguousSubarray(int[] arr) {
		
        // max positive product ending at the current position
        int max_ending_here = 1;
 
        // min negative product ending at the current position
        int min_ending_here = 1;
 
        // Initialize overall max product
        int max_so_far = 1;
        
        for (int element : arr){
        	// if number is positive number
        	if(element > 0){
        		max_ending_here = max_ending_here * element;
        		min_ending_here = Math.min(min_ending_here * element, 1);
        	}else if(element == 0){
        		min_ending_here = 1;
        		min_ending_here = 1;
        	}else{
        		//when element is -ve
        		int temp = max_ending_here;
        		max_ending_here = Math.max(min_ending_here * element, 1);
        		min_ending_here = temp*element;
        	}
        	if(max_so_far < max_ending_here){
        		max_so_far = max_ending_here;
        	}
        }
        System.out.println(max_so_far);
	}

	

}
