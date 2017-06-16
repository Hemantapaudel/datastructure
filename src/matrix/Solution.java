package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	static long calculatePossibleCombinations(String input) {
       return decode("",input).size();
    }
	static public Set<String> decode(String prefix, String input) {
		Set<String> set = new HashSet<String>();
		if (input.length() == 0) {
			set.add(prefix);
			return set;
		}

		if (input.charAt(0) == '0')
			return set;

		set.addAll(decode(prefix + (char) (input.charAt(0) - '1' + 'a'),
				input.substring(1)));
		if (input.length() >= 2 && input.charAt(0) == '1') {
			set.addAll(decode(
					prefix + (char) (10 + input.charAt(1) - '1' + 'a'),
					input.substring(2)));
		}
		if (input.length() >= 2 && input.charAt(0) == '2'
				&& input.charAt(1) <= '6') {
			set.addAll(decode(
					prefix + (char) (20 + input.charAt(1) - '1' + 'a'),
					input.substring(2)));
		}
		return set;
}
	
	
	public static Set<String> decode(String in) {
		char curChar = 'a';
		Map<Integer, Character> numberToChar = new HashMap<Integer, Character>();
		for (int i = 1; i <= 26; i++) {
			numberToChar.put(i, curChar);
			curChar++;
		}
		return decodeHelper(numberToChar, in, 0, new ArrayList<Character>());
	}

		private static Set<String> decodeHelper(
		Map<Integer, Character> numberToChar, String in, int charAt,
			ArrayList<Character> arrayList) {
		Set<String> result = new HashSet<String>();
		if (charAt >= in.length()) {
			String str = "";
			for (char c : arrayList) {
				str += c;
			}
			result.add(str);
			return result;
		} else {
			int charCode = Integer.valueOf(in.charAt(charAt) + "");
			if (charCode == 0) {
				int precCharCode = Integer.valueOf(in.charAt(charAt - 1) + "");
				if (precCharCode == 1)
					charCode = 10;
				if (precCharCode == 2)
					charCode = 20;
			}
			char curChar = numberToChar.get(charCode);
			arrayList.add(curChar);
			result.addAll(decodeHelper(numberToChar, in, charAt + 1, arrayList));
			arrayList.remove(arrayList.size() - 1);
			if (in.length() > charAt + 1) {
				charCode = Integer.valueOf(in.substring(charAt, charAt + 2));
				if (charCode <= 26) {
					curChar = numberToChar.get(charCode);
					arrayList.add(curChar);
					result.addAll(decodeHelper(numberToChar, in, charAt + 2,
							arrayList));
					arrayList.remove(arrayList.size() - 1);
				}
			}
		}
		return result;
	}
		
	
	public static void main(String[] args) {
		
      int []arr = {1,2,3,4,5};
      
      Arrays.sort(arr);
      int min = sum(arr,0,4 );
      int max = sum(arr,1,5 );
      
		
		System.out.println(Solution.calculatePossibleCombinations("2101"));
		System.out.println(min +" "+max);
	}
	
	static int sum(int arr[],int i,int j){
		int sum =0;
		while(i<j){
			sum = sum+ arr[i];
			i++;
		}
		return sum;
	}

}
