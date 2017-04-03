package arrays;
import java.util.Arrays;

public class ReverseAnArray {
	
	public static void reverseString(String message){
		String []list = message.split(" ");
		String result ="";
		for(int i=0; i< list.length;i++){
			String reverseWord = reverseWord(list[i]);
			result = result+ reverseWord +" ";
		}
		message =result;
		System.out.println(message);
	}

	private static String reverseWord(String wordString) {
		char [] charArray = wordString.toCharArray();
		int start=0;
		int end =charArray.length-1;
		while(start<end){
			char character = charArray[start];
			charArray[start]= charArray[end];
			charArray[end]= character;
			start++;
			end--;
		}
		return String.valueOf(charArray);
		
	}
	
	public static void reverseAnArray(int [] arr){
		int start=0;
		int end =arr.length-1;
		while(start<end){
			int temp = arr[start];
			arr[start]= arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
		
	}
	
	
	public static  void reverserAnArrayRecursively(int []arr,int start,int end){
		if(start>=end){
			return;
		}
		int temp =arr[start];
		arr[start] =arr[end];
		arr[end] = temp;
		reverserAnArrayRecursively(arr, start+1, end-1);
	}
	
	public static void main(String[] args) {
		int arr[] ={5,10,15,20,25,30};
		reverseAnArray(arr);
		System.out.println(Arrays.toString(arr));
		reverserAnArrayRecursively(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
		String message = "I got surprise when I got to know you are here today";
		reverseString(message);
	}
}
