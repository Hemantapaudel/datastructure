package arrays;

//Divide and conquer in O(n)
public class FindMinInLogN {

	public int getMin(int[] arr, int start, int end) {
		if (start == end) {
			return arr[start];
		}
		int mid = (start + end) / 2;
		// System.out.println(mid);
		int first = getMin(arr, start, mid);
		int second = getMin(arr, mid + 1, end);
		System.out.println("first=" + first + "second =" + second);

		if (first < second)
			return first;

		else
			return second;
	}

	public static void main(String[] args) {
		System.out.println(new FindMinInLogN().getMin(new int[] { 2, 4, 6, 7,10, 11, 13 }, 0, 6));

	}

}
