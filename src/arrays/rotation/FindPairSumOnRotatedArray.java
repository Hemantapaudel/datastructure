package arrays.rotation;

public class FindPairSumOnRotatedArray {

	private static void printPairSum(int[] arr, int sum) {

		int maxIndex = arr.length - 1;
		int minIndex = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				maxIndex = i;
				minIndex = i + 1;
				break;
			}
		}
		int n = arr.length;

		while (minIndex != maxIndex) {

			if (arr[minIndex] + arr[maxIndex] == sum) {
				System.out.println(" lower index " + minIndex + " higher index " + maxIndex);
				maxIndex = (n + maxIndex - 1) % n;
				minIndex = (minIndex + 1) % n;
			}
			//System.out.println("min index "+maxIndex +" max index = "+maxIndex);
			if (arr[minIndex] + arr[maxIndex] > sum) {
				maxIndex = (n + maxIndex - 1) % n;
			} else {
				minIndex = (minIndex + 1) % n;
			}

		}

	}

	
	public static void main(String[] args) {
		printPairSum(new int[]{11, 15, 6, 8, 9, 10}, 16);
	}


}
