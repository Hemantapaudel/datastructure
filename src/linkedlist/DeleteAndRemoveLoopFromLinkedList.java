package linkedlist;
/**
 *
 * Detect and Remove Loop in a Linked List
 * Write a function detectAndRemoveLoop() that checks whether a given Linked List contains loop 
 * and if loop is present then removes the loop and returns true. And if the list doesn’t contain
 * loop then returns false.
 *
 */
public class DeleteAndRemoveLoopFromLinkedList {
	public static void main(String[] args) {
		
		Node node1 = new Node(5);
		Node node2 = new Node(10);
		Node node3 = new Node(15);
		Node node4 = new Node(20);
		Node node5 = new Node(25);
		Node node6 = new Node(30);
		Node node7 = new Node(35);
		Node node8 = new Node(40,node4);
		
		LinkedList list = new LinkedList(node1,node2,node3,node4,node5,node6,node7,node8);
		
		System.out.println(list.detectAndRemoveLoop(list.getHead()));
		
		
		
	}

}
