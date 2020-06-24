package arrays;

public class MaximumSubOfSubArray {

    public static void main(String[] args) {

        int [] arr = {-1,-3,4,5,-1};
        int size = arr.length;

        int maximumSum = Integer.MIN_VALUE;
        int max_sum_ending_here=0;

        for(int i = 0;i< size;i++){
            max_sum_ending_here = max_sum_ending_here + arr[i];
            if(max_sum_ending_here > maximumSum){
                maximumSum= max_sum_ending_here;
            }else if(max_sum_ending_here<0){
                max_sum_ending_here=0;
            }
        }
        System.out.println( maximumSum);

    }


}
