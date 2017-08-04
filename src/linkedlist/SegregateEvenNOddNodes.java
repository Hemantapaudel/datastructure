package linkedlist;

public class SegregateEvenNOddNodes {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node node = new Node(10);
		list.addNode(node);
		list.sortedInsert(list.getHead(), new Node(20));
		list.sortedInsert(list.getHead(), new Node(30));
		list.sortedInsert(list.getHead(), new Node(40));
		list.sortedInsert(list.getHead(), new Node(35));
		list.sortedInsert(list.getHead(), new Node(25));
		list.sortedInsert(list.getHead(), new Node(15));
		list.sortedInsert(list.getHead(), new Node(20));
		list.sortedInsert(list.getHead(), new Node(2));
		list.sortedInsert(list.getHead(), new Node(22));
		list.traversalList();
		
	}	
}