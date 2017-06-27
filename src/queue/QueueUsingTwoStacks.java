package queue;

import java.util.Stack;

public class QueueUsingTwoStacks {
 
	private Stack<Character> stack1 = new Stack<Character>();
	private Stack<Character> stack2 = new Stack<Character>();
	
	public QueueUsingTwoStacks(){
		stack1 = new Stack<Character>();
	    stack2 = new Stack<Character>();
	}
	
	
   public boolean isEmpty(){
	   return stack1.isEmpty() && stack2.isEmpty();
   }
   
   public void enqueue(char ch){
	   stack1.push(ch);
   }
   
   
   public Character deQueue(){
	   if(!stack2.isEmpty()){
		   return stack2.pop();
	   }
	   if(stack1.isEmpty()){
		   throw new RuntimeException("Queue underflow exeception");
	   }
	   //copy from stack1 to stack2
	      while(!stack1.isEmpty()){
			   stack2.push(stack1.pop());
		   }
	   return stack2.pop();
   }
   
   
   
   
   
	
	public static void main(String[] args) {

		
		QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
		queue.enqueue('A');
		queue.enqueue('B');
		queue.enqueue('C');
		queue.enqueue('D');
		System.out.println(queue.deQueue());
		queue.enqueue('E');
		while(!queue.isEmpty()){
			System.out.println(queue.deQueue());
		}
	}
}
