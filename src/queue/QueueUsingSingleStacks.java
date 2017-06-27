package queue;

import java.util.Stack;

public class QueueUsingSingleStacks {
 
	private Stack<Character> stack1 = new Stack<Character>();
	
	public QueueUsingSingleStacks(){
		stack1 = new Stack<Character>();
	}
	
   public boolean isEmpty(){
	   return stack1.isEmpty();
   }
   
   public void enqueue(char ch){
	   insertAtBottom( stack1,  ch);
   }
   
   private void insertAtBottom(Stack<Character> stack, Character data){
	
	   if(stack.isEmpty()){
		stack.push(data);   
	   }else{
		   Character temp  = stack.pop();
		   insertAtBottom(stack, data);
		   stack.push(temp);
	   }
   }
   
   
   
   public Character deQueue(){
	   
	   if(stack1.isEmpty()){
		   throw new RuntimeException("UnderFlow condition");
	   }
	   return stack1.pop();
	   
	   //  return getBottomItem(stack1);*/
	      
   }
   
  /* private char getBottomItem(Stack <Character>stack){
	   
	   Character last = null;
	   Character temp = stack1.pop();
	   if(stack1.isEmpty()){
		   return temp;
	   }else{
		    last = getBottomItem(stack);
	        stack.push(temp);   
	   }        
	   return last;
   }*/
   
   
   
   
   
   
   
   
	
	public static void main(String[] args) {

		
		QueueUsingSingleStacks queue = new QueueUsingSingleStacks();
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
