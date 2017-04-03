package arrays;

import java.util.Arrays;

/*
 *An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader.
 * For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 **/
public class LeadersElementInArray {

	public static void findLeadersElementInArray(int[] arr) {
		int max_from_right = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (max_from_right < arr[i]) {
				System.out.print("   " + arr[i]);
				max_from_right = arr[i];
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 15, 2, 8, 12, 4, 1, 10 };
		System.out.println(Arrays.toString(arr));
		findLeadersElementInArray(arr);
	}
}
