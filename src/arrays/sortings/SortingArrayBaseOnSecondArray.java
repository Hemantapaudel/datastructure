package arrays.sortings;

import java.util.HashMap;
import java.util.Map;

import arrays.ArrayUtils;

public class SortingArrayBaseOnSecondArray {

	/**
	 * Sort an array according to the order defined by another array
	 */
	public static void sortArrayBaseOnDiffArray(int A1[], int A2[]) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int key : A1) {
			map.put(key, map.get(key) == null ? 1 : map.get(key) + 1);
		}

		int[] temp = new int[A1.length];
		int lastFieldIndex = -1;
		for (int element : A2) {
			System.out.println("");
			if (map.get(element) != null) {
				int count = map.get(element);
				while (count > 0) {
					count--;
					lastFieldIndex++;
					temp[lastFieldIndex] = element;
				}
				map.remove(element);
			}
		}
		System.out.println(lastFieldIndex);

		int pendingElementCount = A1.length - (lastFieldIndex + 1);
		int[] temp2 = new int[pendingElementCount];

		int index = 0;
		for (Integer key : map.keySet()) {
			int count = map.get(key);
			while (count > 0) {
				count--;
				temp2[index] = key;
				index++;
			}
		}
		MergeSort.mergersort(temp2);

		for (int element : temp2) {
			lastFieldIndex++;
			temp[lastFieldIndex] = element;
		}

		ArrayUtils.print(temp, 0, lastFieldIndex);

	}

	public static void main(String[] args) {
		int A1[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int A2[] = { 2, 1, 8, 3 };

		sortArrayBaseOnDiffArray(A1, A2);

	}

}
