package arrays;

/**
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted
 * 
 * @author Hemanta
 *
 */
public class CountInversionOfArray {
	
	public static int countInversion(int []arr){
		if(arr==null ||arr.length==0){
			throw new RuntimeException("this is empty array");
		}
		int inversionCount =0;
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					System.out.println("("+arr[i]+","+arr[j]+") ");
					inversionCount++;
				}
			}
		}
		return inversionCount;
	}
	

	public static void main(String[] args) {
		int []arr ={2, 4, 1, 3, 5,3,6};
		System.out.println(countInversion(arr));

	}

}
