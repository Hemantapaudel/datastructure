package arrays;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {

		int arr[] = { 11, 13, 21, 3 };
		printNGV(arr);
	}

	private static void printNGV(int[]arr){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[0]);
        
        for(int i=1;i< arr.length;i++){
        	int next = arr[i];
        	
        	if(!stack.isEmpty() && stack.peek() < next){
        		while( !stack.isEmpty() && stack.peek() < next ){
        			System.out.println(" element = "+ stack.pop() + " NGV = "+next);
        		}
        	} 	
        	stack.push(next);
        }
        
        while( !stack.isEmpty()){
        	int element = stack.pop();
        	System.out.println(" element = "+ element + " NGV = "+-1);
        }
	}
}
