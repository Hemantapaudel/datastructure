package arrays.sortings;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class AbsoluteDifferentSort {

	public static void absoluteDifferentSort(int[] arr, int x) {
		Map<Integer, ArrayList<Integer>> multiMap = new TreeMap<Integer, ArrayList<Integer>>();
		for (Integer element : arr) {
			int absDiff = Math.abs(element - x);
			if (multiMap.get(absDiff) == null) {
				multiMap.put(absDiff, new ArrayList<Integer>());
			}
			multiMap.get(absDiff).add(element);
		}
		for (Entry<Integer, ArrayList<Integer>> entry : multiMap.entrySet()) {
			for (int a : entry.getValue()) {
				System.out.println(a);
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 5, 3, 9, 2 };
		int x = 7;
		absoluteDifferentSort(arr, x);
	}
}
