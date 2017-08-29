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
	
	public static int[] copy(int[]arr){
		return Arrays.copyOf(arr, arr.length);
	}
	
	public static  void print(int []arr){
		System.out.println(Arrays.toString(arr));
	}
	public static  void print(char []arr){
		System.out.println(Arrays.toString(arr));
	}
	public static  void print(int [][]arr){
		for(int i =0;i< arr.length;i++){
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	public static void print(int []arr, int lowerIndex, int higherIndex){
		
		 StringBuilder b = new StringBuilder();
	        b.append('[');
	        for (int i = lowerIndex; i<=higherIndex ;i++) {
	            b.append(arr[i]);
	            if (i == higherIndex)
	                 b.append(']');
	            b.append(", ");
	        }
	        System.out.println(b.toString());
	}
	
	public static void print(char []arr, int lowerIndex, int higherIndex){
		
		 StringBuilder b = new StringBuilder();
	        b.append('[');
	        for (int i = lowerIndex; i<=higherIndex ;i++) {
	            b.append(arr[i]);
	            if (i == higherIndex)
	                 b.append(']');
	            b.append(", ");
	        }
	        System.out.println(b.toString());
	}
	
	public static void print(int []arr, int... indexs){
		 StringBuilder b = new StringBuilder();
		 b.append('[');
		 for(int index : indexs){
			 b.append(arr[index]+",");
		 }
		 b.deleteCharAt(b.length()-1);
		 System.out.println(b.append(']').toString());
	}
	
	
	
	
}
