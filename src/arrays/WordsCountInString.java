package arrays;

public class WordsCountInString {

	public static int getLength(String str) {
		int length = 0;
		try {
			while (true) {
				str.charAt(length);
				length++;
			}
		} catch (StringIndexOutOfBoundsException e) {
		}
		System.out.println("Length of String is::" + length);
		return length;
	}

	public static int wordCountInSentance(String sentence) {
		//copy the sentence into the character array
		int n = getLength(sentence);
		char[] chr = new char[n];
		for (int i = 0; i < n; i++) {
			chr[i] = sentence.charAt(i);
		}
		
		int count = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if ((i == 0 && chr[0] != ' ')
					|| (i > 0 && chr[i] != ' ' && chr[i - 1] == ' ')
					)
				count++;
		}
		return count;
	}

	public static void main(String args[]) {
		String sen = "   manchester    united is also known as red devil ";
		System.out.println("World count::"
				+ wordCountInSentance(sen));

	}
}
