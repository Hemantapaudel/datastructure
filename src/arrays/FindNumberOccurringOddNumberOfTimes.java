package arrays;



import java.util.Hashtable;
import java.util.Iterator;

/**
 * Find the Number Occurring Odd Number of Times
 * 
 * Given an array of positive integers. All numbers occur even number of times
 * except one number which occurs odd number of times. Find the number in O(n)
 * time & constant space.
 *
 */
public class FindNumberOccurringOddNumberOfTimes {

	public static void main(String[] args) {

		int arr[] = new int[] { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
		//using loop
		printOddOccurrence(arr);
		//using hash map
		printOddOccurrenceUsingHashMap(arr);
		//using XOR operator
		printOddOccurrenceUsingXOR(arr);
	}

	/**
	 * 
	 * A Simple Solution is to run two nested loops. The outer loop picks all
	 * elements one by one and inner loop counts number of occurrences of the
	 * element picked by outer loop. Time complexity of this solution is O(n2).
	 */
	public static void printOddOccurrence(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count % 2 == 1) {
				System.out.println("Odd number is ::" + arr[i]);
				break;
			}
		}
	}

	/**
	 *
	 * A Better Solution is to use Hashing. Use array elements as key and their
	 * counts as value. Create an empty hash table. One by one traverse the
	 * given array elements and store counts. Time complexity of this solution
	 * is O(n). But it requires extra space for hashing
	 * 
	 */
	public static void printOddOccurrenceUsingHashMap(int[] arr) {

		Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
		for (Integer key : arr) {
			hashTable.put(key,(hashTable.get(key) == null ? 0 : hashTable.get(key)) + 1);
		}
		Iterator<Integer> it = hashTable.keySet().iterator();
		while (it.hasNext()) {
			Integer key = (Integer) it.next();
			Integer count = hashTable.get(key);
			if (count % 2 == 1) {
				System.out.println("odd occuring number is ::" + key);
			}
		}
	}

	/**
	 * This method is only applicable if there is only one element has odd occurrence
	 * The Best Solution is to do bitwise XOR of all the elements. XOR of all
	 * elements gives us odd occurring element.
	 * 
	 * Please note that XOR of two  elements is 0 if both elements are same and
	 * XOR of a number x with 0 is x.
	 */
	public static void printOddOccurrenceUsingXOR(int[] arr) {
		System.out.println("XOR of 5^5====" + (5 ^ 5));
		System.out.println("XOR of 5^0====" + (5 ^ 0));
		int result = 0;
		for (int x : arr) {
			result = result ^ x;
			//System.out.println(result);
		}
		System.out.println("odd number occure is ::" + result);
	}

}
