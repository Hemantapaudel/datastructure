package arrays;

import java.util.Scanner;

public class MaximumOfAllSubarraysOfSizeK {

	public static void main(String[] args) {
		System.out.println("");
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
	
		for(int i=0;i< T;i++){
			int N = in.nextInt();
			int K = in.nextInt();
			int [] arr = new int[N];
			for(int j=0;j<arr.length;j++){
				arr[j] = in.nextInt();
			}
			System.out.println();
			findMaxOfSubArray(arr,K);
		System.out.println();	
		}
		in.close();
		
	}
	
	public static void findMaxOfSubArray(int []arr, int k){
		int n = arr.length;
		int j, max;
		 
	    for (int i = 0; i <= n-k; i++)
	    {
	        max = arr[i];
	 
	        for (j = 1; j < k; j++)
	        {
	            if (arr[i+j] > max)
	               max = arr[i+j];
	        }
	        System.out.print( max);
	    }
		
	}

}
