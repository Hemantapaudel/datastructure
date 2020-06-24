package arrays.rotation;

import java.util.Arrays;

public class RotateArrayByD {

	//Method1:  using temporary array size d
	public static void rotateArryInLeft(int arr[], int d) {
		//copy first d elements in temporary array.
		int[] temp = new int[d];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = arr[i];
		}
		// shifted all element from d to zero i.e. arr[0] =arr[d],arr[1] =arr[d+1]
		for (int i = 0; i < (arr.length-d); i++) {
			arr[i] = arr[i+d];
		}
		// shifted temp array element to last of array.
		for (int i =0,index = arr.length-d;i<temp.length;i++,index++){
			arr[index] = temp[i];	
		}
	}
	//Method 2 : one by one element
	public static void RotateOneByOne(int[] arr, int d) {
		for (int i = 0; i < d; i++) {	
			int temp = arr[0];
			for (int j = 0; j < arr.length - 1; j++) {
				arr[j] = arr[j + 1];
			}
			// put first element in last index
			arr[arr.length-1] = temp;
		}
	}



	//Method 3 : reversal algorithms
	public static void RotateByReversalAlgorithm(int arr[], int d) {
		// reverse first d elements
		reverseArray(arr, 0, d - 1);

		// reverse last n-d elements
		reverseArray(arr, d, arr.length - 1);

		// reverse all elements
		reverseArray(arr, 0, arr.length - 1);
	}

	public static void reverseArray(int[] arr, int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			end--;
			start++;
		}
	}


	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int d = 3;
		/*System.out.println("original array is ::"+Arrays.toString(arr));
		rotateArryInLeft(arr, d);
		System.out.println("after rotate by 3 array is ::"+Arrays.toString(arr));
		RotateOneByOne(arr, 2);
		System.out.println("after rotate by 2 array is ::"+Arrays.toString(arr));
		RotateByReversalAlgorithm(arr, 2);
		System.out.println("after rotate by 2 array is ::"+Arrays.toString(arr));*/
		arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		shifted(arr, 2);
		System.out.println("after rotate by 2 array is ::"+Arrays.toString(arr));
		
	}

	//Method 3 : reversal algorithms
	public static void shifted(int arr[], int D) {

		int N = arr.length;
        int [] temp = new int[arr.length];
		for(int i=0; i< arr.length;i++){
			temp[i] = arr[i];
		}

		for(int i =0; i< arr.length;i++){
			arr[i] = temp[(i+D)%N];
		}





	}

}
