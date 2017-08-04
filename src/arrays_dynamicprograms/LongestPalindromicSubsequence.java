package arrays_dynamicprograms;

public class LongestPalindromicSubsequence {

	public static int longestPalidrome(char str[], int start, int length) {
		if (length == 1) {
			return 1;
		}
		if (length == 0) {
			return 0;
		}
		if (str[start] == str[start + length - 1]) {
			return 2 + longestPalidrome(str, start + 1, length - 2);
		} else {
			return Math.max(longestPalidrome(str, start + 1, length - 1),
					longestPalidrome(str, start, length - 1));
		}
	}
	
	

	public static void main(String[] args) {
		String str = "agbdba";
		System.out
				.println(longestPalidrome(str.toCharArray(), 0, str.length()));
	}
}
 