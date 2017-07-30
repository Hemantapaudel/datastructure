package linkedlist;

public class FindNthNodeInLinkedList {

	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(15);
		Node n4 = new Node(2);
		Node n5 = new Node(24);
		Node n6 = new Node(60);

		linkedList.addAllNode(n1, n2, n3, n4, n5, n6);
		
		linkedList.traversalList();
		
		linkedList.printMidNode();
		
		linkedList.getNthNodeFromEnd(2);

	}

}
