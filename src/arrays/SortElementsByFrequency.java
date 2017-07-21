package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortElementsByFrequency {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 20, 6,6, 6,4,4,4,5,5,5,5 };
		sortbyfrequency(arr, arr.length);
	}

	private static void sortbyfrequency(int[] arr, int length) {

		Map<Integer, Integer> dataMap = new HashMap<>();
		for (int key : arr) {
			Integer val = dataMap.get(key);
			if (val == null) {
				dataMap.put(key, 1);
			} else {
				dataMap.put(key, val + 1);
			}
		}

		List<Entry<Integer, Integer>> list = new ArrayList<>(dataMap.entrySet());
		Collections.sort(list,(o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

		for (Entry<Integer, Integer> entry : list) {
			for(int i = entry.getValue(); i >0 ; i-- ){
				System.out.println(entry.getKey());
			}
		}

	}

}
