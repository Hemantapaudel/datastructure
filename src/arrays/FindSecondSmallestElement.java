package arrays;

public class FindSecondSmallestElement {

	public static void printSecondSmallestElement(int[] arr){
		int secondSmallest =Integer.MAX_VALUE, smallest  =Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			if(smallest> arr[i]){
				secondSmallest =smallest;
				smallest =arr[i];
			}else if (secondSmallest >arr[i]){
				secondSmallest = arr[i];
			}
		}
		System.out.println("smallest and second smallest elements:"+smallest +"  and  "+secondSmallest);
	}
	
	public static void printSecondLargestElement(int[] arr){
		int second =Integer.MIN_VALUE, first  =Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(first< arr[i]){
				second =first;
				first =arr[i];
			}else if (second < arr[i]){
				second = arr[i];
			}
		}
		System.out.println("Largest and second Largest elements:"+first +"  and  "+second);
	}
	
	
	public static void main(String[] args) {
		int arr[] = new int[] { 20, 60, 10, 70, 80, 85 };
		printSecondSmallestElement(arr);
		printSecondLargestElement(arr);
			
	}

}
