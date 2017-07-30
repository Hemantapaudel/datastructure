package linkedlist;

// how to insert Node on list 
public class InsertNodeOnLinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node node1 = new Node(10);
		Node node2 = new Node(5);
		Node node3 = new Node(15);
		
		list.addNode(node1);
		// insert at first place
		list.AddAtFirst(node2);
		// insert at last place
		list.AddAtLast(node3);
		// insert after node2  
		list.AddAfterGivenNode(node2, new Node(7));
		// insert before node1  
		list.AddBeforGivenNode(node1, new Node(9));
		
		
		list.traversalList();
		
		
		
		
	}

}
