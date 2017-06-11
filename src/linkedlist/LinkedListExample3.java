package linkedlist;


//Find Length of a Linked List (Iterative and Recursive)
public class LinkedListExample3 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node node1 = new Node(10);
		Node node2 = new Node(5);
		Node node3 = new Node(15);
		list.addAllNode(node1,node2,node3);
		list.traversalList();
		System.out.println("\n Iterative way Length :"+list.getLength());
		System.out.println("getLengthRecursive way length :"+ list.getLengthRecursive(list.head));
	}

}
