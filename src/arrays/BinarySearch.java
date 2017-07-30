package arrays;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class BinarySearch {

	public static int binarySearch(int[]arr,int lowerIndex, int upperIndex,int key){
		System.out.println("lowerIndex ="+lowerIndex +" upperIndex= "+upperIndex);
		if(lowerIndex>upperIndex){
			return -1;
		}
		int mid = (lowerIndex+ upperIndex)/2;
		if(key == arr[mid]){
			return mid;
		}		
		if(key >arr[mid]){
			return binarySearch(arr, mid+1, upperIndex, key);
		}
		return binarySearch(arr, lowerIndex, mid-1,	 key);
	}
	public static void main(String[] args) {
		
		AtomicInteger integer = new AtomicInteger();
		integer.getAndIncrement();
		
		Stream<T> sm;
		int [] arr = {1,3,4,6,9,17,21,25,28,36,39,45};
		System.out.println(binarySearch(arr, 0, arr.length-1, 21));
	}
	
}
