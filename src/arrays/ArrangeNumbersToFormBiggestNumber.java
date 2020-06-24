package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeNumbersToFormBiggestNumber {
	
	
	
	private static void formBiggestNumber(Integer []arr){
		Comparator<Integer> comparator = (number1,number2)->{
			String xy = number1.toString().concat(number2.toString());
			String yx = number2.toString().concat(number1.toString());
			//return xy.compareTo(yx);
			return yx.compareTo(xy);
		};
		StringBuffer buffer = new StringBuffer();
		Arrays.stream(arr)
		.sorted(comparator)
		.forEach(element -> buffer.append(element));
		System.out.println(buffer);
	}
	
	

	public static void main(String[] args) {
		Integer []arr = {1, 34, 3, 98, 9, 76, 45, 4};
		formBiggestNumber(arr);
	}
}
