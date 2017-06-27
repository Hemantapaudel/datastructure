package queue;

import linkedlist.Node;

public class QueueIMPLUsingLinkedList {

	Node front;
	Node rear;
	
	public QueueIMPLUsingLinkedList(){
		
	}
	
	public void enQueue(int data){
		
		Node node = new Node(data);
		// if queue is null
		if(rear == null){
			rear = front = node;
		}else{
			// add end of the list
			rear.next = node;
			rear = node;
		}
	}
	
	public boolean isEmpty(){
		if(rear == null || front == null){
			return true;
		}else 
			return false;
	}
	// dequeue from the head
	public int deQueue(){
		if(front== null){
			return Integer.MIN_VALUE;
		}		
		Node node = front;
		front = front.next;
		if(front == null){
			this.front = this.rear = null;
		}
		node.next =null;
		return node.getData();
	}
	
	
	
	
	public static void main(String[] args) {
		
		QueueIMPLUsingLinkedList queueIMPLUsingLinkedList = new QueueIMPLUsingLinkedList();
		queueIMPLUsingLinkedList.enQueue(10);
		queueIMPLUsingLinkedList.enQueue(10);
		queueIMPLUsingLinkedList.enQueue(10);
		queueIMPLUsingLinkedList.enQueue(10);
		queueIMPLUsingLinkedList.enQueue(10);
		queueIMPLUsingLinkedList.enQueue(10);
		queueIMPLUsingLinkedList.enQueue(10);
		queueIMPLUsingLinkedList.enQueue(10);
		queueIMPLUsingLinkedList.enQueue(10);
		queueIMPLUsingLinkedList.enQueue(10);
		queueIMPLUsingLinkedList.enQueue(10);
		queueIMPLUsingLinkedList.enQueue(10);
		
		while(! queueIMPLUsingLinkedList.isEmpty()){
			System.out.println(queueIMPLUsingLinkedList.deQueue());
		}
	
	}
}
