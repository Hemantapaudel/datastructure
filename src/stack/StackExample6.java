package stack;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 * 
 * Implement Stack using Queues
 *
 *push(s,  x)
  1) Enqueue x to q1 (assuming size of q1 is unlimited).

	pop(s)  
  1) One by one dequeue everything except the last element from q1 and enqueue to q2.
  2) Dequeue the last item of q1, the dequeued item is result, store it.
  3) Swap the names of q1 and q2
  4) Return the item stored in step 2.
// Swapping of names is done to avoid one more movement of all elements 
// from q2 to q1.
 *
 */

class StackUsingQueue{
	
	List<Integer> queue1 = new LinkedList<Integer>();
	List<Integer> queue2 = new LinkedList<Integer>();

	public void push(int data){
		queue1.add(data);
	}
	
	public int pop(){
		
		if(queue1.isEmpty()){
			System.out.println("stack underflow ");
			return -1;
		}
		// copy queue1 to queue2 expect last element
		Iterator< Integer> it = queue1.iterator();
		int data =-1;
		while(it.hasNext()){
			data  = it.next();
			if(it.hasNext()){
				queue2.add(data);
			}
		}
		
		// copy back to queue1 from queue2 
		Iterator<Integer> it2 = queue2.iterator();
		while(it2.hasNext()){
			queue1.add(it2.next());
		}
		
		return data;
	}
	
	
	
}

public class StackExample6 {
	public static void main(String[] args) {
		
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
