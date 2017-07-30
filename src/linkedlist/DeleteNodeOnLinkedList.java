package linkedlist;


//Linked List | Set 3 (Deleting a node)
public class DeleteNodeOnLinkedList {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		Node node1 = new Node(10);
		Node node2 = new Node(5);
		Node node3 = new Node(15);
		list.addAllNode(node1,node2,node3);
		
		list.traversalList();
		
		System.out.println();
		list.deleteNodeAtGivenPosition(1);

		System.out.println();
		list.deleteFirstNode();
		System.out.println();
		list.deleteFirstNode();
		
		// delete node without traversal
		
		
		
		
	}
	
	public static boolean deleteNodeWithOutTraversal(Node node){
		// check for NUll or last node
		if(node == null || node.next == null){
			//this is invalid condition
			return Boolean.FALSE;
		}
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		temp.next = null;
		return Boolean.TRUE;
	}	
}
