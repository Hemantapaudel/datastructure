package stack;

public class StackExample4 {
	private java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
	
	public void add(int data){
		stack.push(data);
	}
	
	public void insertAtButtom(int data){
		if(stack.isEmpty()){
			stack.push(data);
		}else{
			int stackData = stack.pop();
			insertAtButtom(data);
			stack.push(stackData);
		}
	}

	public void printStack(){
		System.out.println();
		print();
		System.out.println();
	}

	private void print(){
		if(stack.isEmpty()){
			return;
		}
		int data = stack.pop();
		System.out.print(" " + data);
		print();
		stack.push(data);
	}
	
	
	public void reverse(){
		if(stack.size()>0){
			int data = stack.pop();
			reverse();
			insertAtButtom(data);
		}
	}
	
	public static void main(String[] args) {
		
		StackExample4 stackExample4 = new StackExample4();
		stackExample4.add(10);
		stackExample4.add(20);
		stackExample4.add(30);
		stackExample4.add(40);
		stackExample4.add(50);
		
		
		stackExample4.insertAtButtom(0);
		stackExample4.printStack();


		stackExample4.reverse();
		stackExample4.printStack();
		
	}

}
