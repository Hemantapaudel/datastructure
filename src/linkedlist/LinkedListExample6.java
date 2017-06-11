package linkedlist;

/*
 * Reverse a Linked List in groups of given size
 */
public class LinkedListExample6 {
	public static void main(String[] args) {
		
		int []numbers = {5,10,15,20,25,30,35,40,45,50};
		LinkedList list = LinkedListUtils.creatList(numbers);
		list.traversalList();
		
		
		
		Node head = list.reverseLinkedList(list.getHead(),3);
		list.setHead(head);
		list.traversalList();
	}

}
