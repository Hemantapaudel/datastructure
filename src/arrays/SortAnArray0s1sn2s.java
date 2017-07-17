package arrays;

/**
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[].
 * The functions should put all 0s first, then all 1s and all 2s in last.
 *
 * Example Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}; Output = {0, 0, 0, 0,
 * 0, 1, 1, 1, 1, 1, 2, 2}
 *
 **/

public class SortAnArray0s1sn2s {

	//using count concept 
	public static void sortAnArray0s1sn2s(int arr[]) {
		int size = arr.length;
		int zerosCount = 0;
		int onesCount = 0;
		int twosCount = 0;

		for (int i = 0; i < size; i++) {
			if (arr[i] == 0) {
				zerosCount++;
			} else if (arr[i] == 1) {
				onesCount++;
			} else if (arr[i] == 2) {
				twosCount++;
			}
		}

		int index = 0;
		for (int i = 0; i < zerosCount; i++) {
			arr[index] = 0;
			index++;
		}
		for (int i = 0; i < onesCount; i++) {
			arr[index] = 1;
			index++;
		}
		for (int i = 0; i < twosCount; i++) {
			arr[index] = 2;
			index++;
		}
		ArrayUtils.print(arr);	
	}

	// moving zeros to lower side and 2s into higher side
	
	private static void sort012(int []arr){
		int lower =0;
		int high = arr.length-1;
		int currentElement;
		for(int i=0; i<= high; i++){
			System.out.println("lower = "+lower +" current i = "+i + " higher index = "+ high);
			ArrayUtils.print(arr);
			if(arr[i] ==0){
				// move element into lower index i.e. exchange with current and lower
				currentElement = arr[i];
				arr[i] = arr[lower];
				arr[lower] = currentElement;
				lower++;
			}else if(arr[i] == 1){
				continue;
			}else{
				// this is two element
				currentElement = arr[i];
				arr[i] = arr[high];
				arr[high]= currentElement;
				high--;
				i--;//processing same element again
			}
			ArrayUtils.print(arr);	
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

		SortAnArray0s1sn2s.sort012(arr);
		SortAnArray0s1sn2s.sortAnArray0s1sn2s(arr);
	}

}
