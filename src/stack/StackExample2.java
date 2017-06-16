package stack;

/**
 * Coversion from infix operation into postfix operation 
 * 
 * Algorithm
1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output it.
3. Else,
…..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty), push it.
…..3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal to the precedence of the operator residing on the top of the stack. Push the scanned operator to the stack.
4. If the scanned character is an ‘(‘, push it to the stack.
5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
6. Repeat steps 2-6 until infix expression is scanned.
7. Pop and output from the stack until it is not empty.
 *
 */
public class StackExample2 {

	static int prec(char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }
      
	
	 static String infixToPostfix(String exp){
		 StringBuffer result = new StringBuffer("");
		 java.util.Stack<Character> stack = new java.util.Stack<>();
         char [] arr = exp.toCharArray();
	        for (int i = 0; i<arr.length; ++i){
	        	char ch = arr[i];
	        	if(Character.isLetterOrDigit(ch)){
	        		result.append(ch);
	        	}else if(ch == '('){
	        		stack.push(ch);
	        	}else if(ch == ')'){
	        		while( !stack.isEmpty()   && stack.peek() != '('){
	        			result.append(stack.pop());
	        		}
	        		// pop out the '('
	        		stack.pop();
	        	}else{
	        		// an operator is encountered
	        		while( !stack.isEmpty() && prec(ch) <= prec(stack.peek()) ){
	        			result.append(stack.pop());
	        		}
	        		stack.push(ch);
	        	}
	 
	        }
		 return result.toString();
	 }
	
	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
	}

}
