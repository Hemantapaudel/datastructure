package arrays;

import java.util.Arrays;

public   final class ArrayUtils {
	
	public static  int getMin(int []arr){
		int min =arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]<min){
				min= arr[i];
			}
		}
		return min;
	}
	
	public static  int getMax(int []arr){
		int max =arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max= arr[i];
			}
		}
		return max;
	}
	
	public static  void print(int []arr){
		System.out.println(Arrays.toString(arr));
	}

}
