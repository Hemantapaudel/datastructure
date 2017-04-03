package arrays;

import java.util.Arrays;

public class UnionAndIntersectionOfSortedArray {

	public static void printUnion(int[] arr1, int []arr2){
		
		int [] unionArray= new int[arr1.length+arr2.length];
		int unionArrayIndex =0,i=0,j=0;
		
		while(i<arr1.length   &&  j< arr2.length){
			if(arr1[i]>arr2[j]){
				unionArray[unionArrayIndex]= arr2[j];
				j++;
				unionArrayIndex++;
			}else if(arr1[i]<arr2[j]){
				unionArray[unionArrayIndex]= arr1[i];
				i++;
				unionArrayIndex++;
			}else{
				unionArray[unionArrayIndex]= arr1[i];
				i++;
				j++;
				unionArrayIndex++;
			}
		}
		//now either one of array is completely iterated
		while(i<arr1.length){
			unionArray[unionArrayIndex]= arr1[i];
			i++;
			unionArrayIndex++;
		}
		
		while(j<arr2.length){
			unionArray[unionArrayIndex]= arr2[j];
			j++;
			unionArrayIndex++;
		}
		
		System.out.println(Arrays.toString(unionArray));
	}
	
public static void printIntersection(int[] arr1, int []arr2){
		int [] unionArray= new int[(arr1.length>arr2.length)?arr2.length:arr1.length];
		int unionArrayIndex =0,i=0,j=0;
		
		while(i<arr1.length   &&  j< arr2.length){
			if(arr1[i]>arr2[j]){
				j++;
			}else if(arr1[i]<arr2[j]){
				i++;
			}else{
				unionArray[unionArrayIndex]= arr1[i];
				i++;
				j++;
				unionArrayIndex++;
			}
		}
		System.out.println(Arrays.toString(unionArray));
	}
	
	public static void main(String[] args) {
		int []arr1 ={1,3,4,5,8,9,15,18,20,25,35,36,40};
		int []arr2 ={1,4,8,15,25,3+2,36,37,38,40,45,50};
		
		printUnion(arr1, arr2);
		printIntersection(arr1, arr2);
		
		
	}

}
