package matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	static long calculatePossibleCombinations(String input) {
       return findAllCodes(input).size();
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
	
private static List<String> findAllCodes(String string) {

		
		List<String> ret = new ArrayList<String>();
		List<String> preRet = new ArrayList<String>();

		for (int index = 0; index < string.length(); index ++){
			List<String> temp1 = new ArrayList<String>();
			List<String> temp2 = new ArrayList<String>();
				if (index >=  1){
					int val = Integer.valueOf(string.substring(index - 1, index + 1));
					if (val <= 26 && val >= 10){
						char chr = (char)(val + 96);
						temp1 = addChrToPrefix(preRet, chr);
					}
				}
				int val = Integer.valueOf(string.substring(index, index + 1));
				if (val != 0){
					char chr = (char)(val + 96);
					temp2  = addChrToPrefix(ret, chr);
				}
				preRet = ret;
				temp1.addAll(temp2);
				ret = temp1;
			}
		return ret;
	}
	


	private static List<String> addChrToPrefix(List<String> preRet, char chr) {
		
		List<String> ret = new ArrayList<String>();
		if (preRet.size() == 0){
			ret.add(String.valueOf(chr));
		} 
		for (String item : preRet){
			ret.add(item + String.valueOf(chr));
		}
		return ret;
	}

	
	public static void main(String[] args) {
		

		
		System.out.println(Solution.calculatePossibleCombinations("2101"));
	}

}
