package arrays.grouping;


import com.sun.tools.javac.util.ArrayUtils;

public class CountTriangle {

	//Method 1. using three loop
	
	
	//Method2 : using sorting and two loop
	
	public static int printAllTriangleSet(int []arr){
		
		// sorting O(NlogN)
		mergersort(arr);
		
		int count =0;
		
		// fixed first two elements and search third element from j+1 to N, in such that
		// (arr[i]+ arr[j]) > arr[k]
		
		// here array is already sorted arr[i]< arr[j]< arr[k] will always valid
		for(int i =0; i < arr.length-2; i++){
			
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if ((arr[i] + arr[j]) > arr[k]) {
						print(arr, i,j,k);
						count++;
					}
				}
			}
		}		
		return count;
	}

	public static void mergersort(int[] arr) {
		int n = arr.length;
		if (n < 2) {
			return;
		}
		// divide the array into two arrays
		int mid = n / 2;
		//System.out.println("mid ==" + mid);
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		for (int i = 0; i < mid; i++) {
			//System.out.println(arr[i]);
			left[i] = arr[i];
		}
		//System.out.println("---------------");
		for (int i = mid; i < n; i++) {
			//System.out.println(arr[i]);
			right[i - mid] = arr[i];
		}
		// dividing the array recursively
		mergersort(left);
		mergersort(right);

		// merging two sorted array into one array
		merge(left, right, arr);
	}

	public static void merge(int[] left, int right[], int arr[]) {
		int ln = left.length;
		int rn = right.length;
		int i = 0, j = 0, k = 0;
		while (i < ln && j < rn) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				i = i + 1;
			} else {
				arr[k] = right[j];
				j = j + 1;
			}
			k = k + 1;
		}
		while (i < ln) {
			arr[k] = left[i];
			i = i + 1;
			k = k + 1;
		}
		while (j < rn) {
			arr[k] = right[j];
			j = j + 1;
			k = k + 1;
		}
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
	
	public static void main(String[] args) {
		
		 int arr[] = {10, 21, 22, 100, 101, 200, 300};
		 System.out.println(printAllTriangleSet(arr));

	}

}
