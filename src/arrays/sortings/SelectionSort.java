package arrays.sortings;

import java.util.Arrays;

///*Selection Sort
//
//The idea of selection sort is rather simple: we repeatedly find the next largest (or smallest) element in the array and 
//move it to its final position in the sorted array. Assume that we wish to sort the array in increasing order,
// i.e. the smallest element at the beginning of the array and the largest element at the end. We begin by selecting the 
// largest element and moving it to the highest index position. We can do this by swapping the element at the highest index 
// and the largest element. We then reduce the effective size of the array by one element and repeat the process on 
// the smaller (sub)array. The process stops when the effective size of the array becomes 1 (an array of 1 element is already sorted).
//*/
public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 4, 6, 2, 8, 5, 6, 9, 6, 7 };
		selectionSort(arr);
	}

	private static void selectionSort(int[] arr) {
		System.out.println("Original array:"+Arrays.toString(arr));
		int n = arr.length;
		int min, temp;
		for (int i = 0; i < n - 1; i++) {
			min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			System.out.println("when I= "+i+" then  min:"+min);
			// swap ith and min value
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			System.out.println("when I= "+i+" then  array:"+Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
	}
}
