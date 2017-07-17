package arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckSubsetOfArray {
	public static void main(String[] args) {
		int[] arr1 = { 45, 85, 96, 58, 69, 56, 24 };
		int[] arr2 = { 45, 96, 56, 85, 4 };
		int [] arr3 = {85,69,24};
		ArrayUtils.print(arr1);
		ArrayUtils.print(arr2);
		System.out.println(checkSubSetUsingHashMap(arr1, arr2));
		System.out.println(isSubset(arr1, arr2));
		
		
		ArrayUtils.print(arr3);
		System.out.println(checkSubSetUsingHashMap(arr1, arr3));
		System.out.println(isSubset(arr1, arr3));
	}
     /**
      * Method 1 : using hash map
      * @param arr1
      * @param arr2
      * @return
      */
	private static boolean checkSubSetUsingHashMap(int[] arr1, int[] arr2) {
		Map<Integer, String> ls = new HashMap<Integer, String>();
		if (arr1.length < arr2.length) {
			return Boolean.FALSE;
		}
		//big array
		for (int a : arr1) {
			ls.put(a, "A");
		}
		//small array
		for (int a : arr2) {
			if (ls.get(a) == null) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
	
	/**
	 * method 2 : using sorting and merging 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static boolean isSubset(int arr1[], int arr2[]) {
		int i = 0, j = 0;
		if (arr1.length < arr2.length) {
			return Boolean.FALSE;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int n = arr2.length;
		int m = arr1.length;
		while (i < n && j < m) {
			if (arr1[j] < arr2[i])
				j++;
			else if (arr1[j] == arr2[i]) {
				j++;
				i++;
			} else if (arr1[j] > arr2[i])
				return Boolean.FALSE;
		}
		//smaller array is not completely iterate on while loop
		if (i < n){
			System.out.println("==========");
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	} 
	
}
