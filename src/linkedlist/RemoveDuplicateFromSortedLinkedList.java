package linkedlist;

public class RemoveDuplicateFromSortedLinkedList {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		
		Node n7 = new Node(60);
		Node n6 = new Node(60);
		Node n5 = new Node(24);
		Node n4 = new Node(20);
		Node n3 = new Node(15);
		Node n2 = new Node(10);
		Node n1 = new Node(2);
		Node n0 = new Node(2);
		
		linkedList.addAllNode(n7, n6, n5, n4, n3, n2,n1,n0);
		
		linkedList.traversalList();
		
		linkedList.deleteDuplicatesFromSortedList();
	}

}
