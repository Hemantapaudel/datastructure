package arrays;

import java.util.Arrays;


public class PartitionArrayInEqualHalves {

	public int max(int[] A) {
		int max = A[0];
		for (int a : A) {
			if (max < a) {
				max = a;
			}
		}
		return max;
	}

	public int min(int[] A) {
		int min = A[0];
		for (int a : A) {
			if (min > a) {
				min = a;
			}
		}
		return min;
	}

	public static int sum(int A[]) {
		int sum = 0;
		for (int a : A)
			sum += a;
		return sum;
	}

	public static void partitionSum(int[] A) {
		arrays.sortings.MergeSort.mergersort(A);
		System.out.println("array after sorting::" + Arrays.toString(A));
		
		boolean isOdd = (A.length % 2 == 1);
		int size =  isOdd ? (A.length / 2 + 1): (A.length / 2);

		int part1[] = new int[size];
		int part2[] = new int[size];

		int k = 0;
		

		for (int i = 0; i < A.length-1; i = i + 2) {
			if (sum(part1) < sum(part2)) {
				part1[k] = A[i + 1];
				part2[k] = A[i];
			} else {
				part1[k] = A[i];
				part2[k] = A[i + 1];
			}
			k++;
		}

		if (isOdd) {
			if (sum(part1) < sum(part2)) {
				part1[k] = A[A.length - 1];
			} else {
				part2[k] = A[A.length - 1];
			}
		}

		System.out.println("First part1 ");
		ArrayUtils.print(part1);
		
		System.out.println("\n Second part2");
		ArrayUtils.print(part2);
	}

	public static void main(String[] args) {
		partitionSum(new int[] { 45, 45, 7, 8, 412,	25,5 });

	}

}
