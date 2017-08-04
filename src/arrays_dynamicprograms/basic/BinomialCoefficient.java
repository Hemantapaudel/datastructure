package arrays_dynamicprograms.basic;

public class BinomialCoefficient {

	/**
	 * C(n, k) = C(n-1, k-1) + C(n-1, k)
     * C(n, 0) = C(n, n) = 1
	 * 
	 * @param N
	 * @param K
	 * @return
	 */
	public static int binomialCoefficient(int N, int K){
		
		if(K==0 || K == N){
			return 1;
		}
		return binomialCoefficient(N-1, K-1) + binomialCoefficient(N-1, K);
		
	}
	
	public static void main(String[] args) {
		System.out.println(binomialCoefficient(5,2));
	}

}
