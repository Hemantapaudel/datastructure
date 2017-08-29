package string;

import arrays.ArrayUtils;

public class FindAllPalindromeSubStrings {	
	public static int countTotalPDRecursive(char[] arr, int i, int j) {

		if(i ==j || i > j){
			return 0;
		}
		if (i == j - 1 && arr[i] == arr[j]) {
			 //ArrayUtils.print(arr, i, j);
			return 1;
		}
		if (isPalidrome(arr, i, j)) {
			//ArrayUtils.print(arr, i, j);
			return countTotalPDRecursive(arr, i + 1, j) + 1
					+ countTotalPDRecursive(arr, i, j - 1)
					- countTotalPDRecursive(arr, i + 1, j - 1);
		} else {
			return countTotalPDRecursive(arr, i + 1, j)
					+ countTotalPDRecursive(arr, i, j - 1)
					- countTotalPDRecursive(arr, i + 1, j - 1);
		}

	}
	
	public static boolean isPalidrome(char arr[], int i, int j){
		while(i<j){
			if(arr[i] != arr[j]){
				return Boolean.FALSE;
			}
			i ++;
			j--;
		}
		return Boolean.TRUE;
	}
	
	public static int countPSIterative(char []arr, int minimumLength){
		int n = arr.length;
		int count =0;
		int diff = minimumLength-1;
		for(int i =0; i< n-diff; i++){
		  for(int j = i+diff; j < arr.length; j++){
			 // System.out.println( " i = "+i + " j = "+ j);
			  if(isPalidrome(arr, i, j)){
				  ArrayUtils.print(arr, i, j);
				  count++;
			  }
		  }	
		}
		return count;	
	}
	
	public static void main(String[] args) {
		String str = "abaab";
        System.out.println(countTotalPDRecursive(str.toCharArray(), 0, str.length()-1));
        System.out.println(countPSIterative(str.toCharArray(), 2));

	}

}
