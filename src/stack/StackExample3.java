package stack;

/**
 * 
 * Set 4 (Evaluation of Postfix Expression)
 * 1) Create a stack to store operands (or values).
   2) Scan the given expression and do following for every scanned element.
		�..a) If the element is a number, push it into the stack
		�..b) If the element is a operator, pop operands for the operator from stack. Evaluate the operator and push the result back to the stack
	3) When the expression is ended, the number in the stack is the final answer
 */
public class StackExample3 {
	
	public static long evaluatePostfix(String expression){
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		
		char []arr = expression.toCharArray();
		for(int i=0;i< arr.length; i++){
			char ch = arr[i];
			if(Character.isDigit(ch)){
				stack.push(ch - '0');
			}
			else{
				int val1 = stack.pop();
				int val2 = stack.pop();
				switch (ch){
	             case '+': stack.push(val2 + val1); break;
	             case '-': stack.push( val2 - val1); break;
	             case '*': stack.push( val2 * val1); break;
	             case '/': stack.push( val2/val1);   break;
	            }
			}
		}
		return stack.pop();
	}
	public static void main(String[] args) {

		System.out.println("Value of "+StackExample3.evaluatePostfix("231*+9-"));
	}
}
