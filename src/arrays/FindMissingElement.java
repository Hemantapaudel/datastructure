package arrays;

/**
 * find the missing element from the given list 1 to N.
 */
public class FindMissingElement {

	public static void main(String[] args) {
		int[] A = { 1, 8, 2, 9, 3, 4, 6, 7 };
		//single missing number
		printMissingNumber(A);
		printMissingNumberUserXOR(A);
		
		int[] numbers = {1,2,3,4,6,5,7,8,10,9};
		numbers[5]=0;
		numbers[8]=0;
		System.out.println("Given array");
		ArrayUtils.print(numbers);
		findMultipleMissingElementUsingVisitor(numbers);	
		findMultipleMissingElementByModify(numbers);
		ArrayUtils.print(numbers);
	}

	/**
	 * the XOR Operation will help to find out missing element, Here we have 1
	 * to N number where one number is missing Let Missing number is X
	 * 
	 * So let do XOR of given number =>> arr[0]^ arr[1]....^arr[n-1]
	 * 
	 * and also do the XOR of 1 to n number xor ==>>
	 * 1^2^3^..^missingElement^...^n,
	 * 
	 * let do the final XOR of both.... arr[0]^arr[1]^....arr[n-1] ^
	 * 1^2....^missingElement^...^n => missingElement
	 * 
	 */
	private static void printMissingNumberUserXOR(int[] A) {
		// 1. take XOR of all the array element and assign to X
		int x = 0, y = 0;
		for (int i = 0; i < A.length; i++) {
			x = x ^ A[i];
		}
		// 2. take the XOR of 1 to n and then assigned to Y
		for (int i = 1; i <= 9; i++) {
			y = y ^ i;
		}
		System.out.println("Missig Elements::" + (y ^ x));
	}

	private static void printMissingNumber(int[] A) {
		int n = A.length + 1;
		int sum = n * (n + 1) / 2;
		for (int i = 0; i < A.length; i++) {
			sum = sum - A[i];
		}
		System.out.println("Missig Elements::" + sum);
	}
	
	/**
	 * method 3 : we are using visitor array 
	 * 
	 */
	public static void findMultipleMissingElementUsingVisitor(int arr[]){
		int n = arr.length;
		boolean []visitor = new boolean[arr.length+1];
		visitor[0]= true;
		for(int i=1;i<visitor.length;i++){
			visitor[i]=false;
		}
		for(int i=0;i<n;i++){
			visitor[arr[i]]=true;
		}
		for(int i=0;i<visitor.length;i++){
			if(visitor[i] == false){
				System.out.println("mising element="+i);
			}
		}
	} 
	/**
	 * method 4 : we are using by modify given array 
	 * 
	 */
	public static void findMultipleMissingElementByModify(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int index = Math.abs(arr[i]) - 1;
			if (index < 0) {
				continue;
			}
			arr[index] = -arr[index];
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i] > 0){
				System.out.println("mising element is " + (i+1));
			}
		}
	}
	
	
}
