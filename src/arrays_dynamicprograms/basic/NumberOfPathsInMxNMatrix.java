package arrays_dynamicprograms.basic;

public class NumberOfPathsInMxNMatrix {

	public static int totalNumberOfPath(int m, int n) {

		int[][] P = new int[m][n];

		// total path on first row are 1
		for (int i = 0; i < m; i++) {
			P[i][0] = 1;
		}
		// total path for first column are 1
		for (int j = 0; j < n; j++) {
			P[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				P[i][j] = P[i - 1][j] + P[i][j - 1];
			}
		}

		return P[m - 1][n - 1];

	}

	public static void main(String[] args) {

		System.out.println(totalNumberOfPath(4, 4));
	}

}
