package arrays;

import java.util.HashMap;
import java.util.Iterator;

/*
 * A majority element in an array A[] of size n is an element that appears more than n/2 times
 */
public class MajorityElementInArray {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 5, 5, 3, 5, 2, 3, 5, 5, 3, 5, 5, 6 };
		findMajorityElementUsingHashing(arr);
		findMajorityUsingMooresVotingAlgorithm(arr);
	}

	

	/**
	 * Best Method : Moore’s Voting Algorithm //  Time O(N) , and space  O(1)
	 */
	private static void findMajorityUsingMooresVotingAlgorithm(int arr[]){
	int majorElement =	findCandidate(arr);
		//verify whether this is major element or not
	int count =0;
	for(int a : arr){
		if(a == majorElement){
				count++;
			}
		}
		if(count > arr.length/2){
			System.out.println("MAJOR ELEMENT IS "+majorElement);
		}else{
			System.out.println("MAJOR ELEMENT IS NOT AVAILABLE");
		}
		
	}
	
	/**
	 *  this method return a candidate, which could be major element if any major element available on given array 
	 */
	private static int findCandidate(int []arr){
		
		int major_index =0;
		int count =1;
		
		for(int i=1; i< arr.length ;i++){
			if(arr[major_index] == arr[i]){
				count++;
			}else{
				count--;
			}
			if(count == 0){
				major_index = i;
				count =1;
			}
		}
		// this will be the major element if it is available
		return arr[major_index];
		
		
	}
	
	
	
	/**
	 * 
	 * we using hash table to count the repetition , it will take time and space O(N)
	 */
	private static void findMajorityElementUsingHashing(int[] arr) {
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
				System.out.println("Majority elements of an array is:" + key);
				break;
			}
		}
	}
}
