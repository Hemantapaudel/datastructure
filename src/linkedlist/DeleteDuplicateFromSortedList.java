package linkedlist;


public class DeleteDuplicateFromSortedList {

	public static void main(String[] args) {
		Node n112 = new Node(14);
		Node n113 = new Node(24);
		Node n114 = new Node(34);
		Node n115 = new Node(34);
		Node n116 = new Node(44);
		Node n117 = new Node(44);
		Node n118 = new Node(74);
		Node n119 = new Node(84);

		LinkedList linkedList2 = new LinkedList(n112, n113, n114, n115, n116, n117,  n118,n119);
		linkedList2.traversalList();
		linkedList2.deleteDuplicatesFromSortedList();
		
	}

}
