package stack;

/**
 * Sort a stack using recursion
 * 
 *  sortStack(stack S)
	if stack is not empty:
		temp = pop(S);  
		sortStack(S); 
		sortedInsert(S, temp);
 *
 */
public class StackExample7 {

	public static void sortStack(java.util.Stack<Integer> stack){
		if(stack.size()>0){
			int temp = stack.pop();
			sortStack(stack);
			sortedInsertion(stack,temp);
		}
	}
	
	public static void sortedInsertion(java.util.Stack<Integer> stack, int data){
		System.out.println("======data==="+ data);
		if(stack.isEmpty() || data > stack.peek()){
			stack.push(data);
			return;
		}else{
			int temp = stack.pop();
			System.out.println("======temp==="+ temp);
			sortedInsertion( stack,  data);
			stack.push(temp);
		}
	}
	
	public static  void printStack(java.util.Stack<Integer> stack){
		
		if(stack.isEmpty()){
			return;
		}
		int temp = stack.pop();
		System.out.println("stack: "+ temp);
		printStack(stack);
		stack.push(temp);
	}
	
	
	public static void main(String[] args) {
				
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		stack.push(20);
		stack.push(5);
		stack.push(25);
		stack.push(10);
		
		StackExample7.sortStack(stack);
		StackExample7.printStack(stack);
		
		StackExample7.sortedInsertion(stack,12);
		StackExample7.printStack(stack);
		
		
		
	}

}
