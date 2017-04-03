package arrays;

import java.util.HashMap;
import java.util.Iterator;

/*
 * A majority element in an array A[] of size n is an element that appears more than n/2 times
 */
public class MajorityElementInArray {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 5, 5, 3, 5, 2, 3, 5, 5, 3, 5, 5, 6 };
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hs.get(arr[i]) == null) {
				hs.put(arr[i], 1);
			} else {
				hs.put(arr[i], hs.get(arr[i]) + 1);
			}
		}
		Iterator<Integer> it = hs.keySet().iterator();
		while (it.hasNext()) {
			Integer key = it.next();
			if (hs.get(key) > (arr.length / 2)) {
				System.out.println("Majority elements of an array is :" + key
						+ " where count is::" + hs.get(key));
				break;
			}
		}
	}
}
