package linkedlist;

public class DeleteNodeWhichhavingGreaterValueOnRightSide {
	public static void main(String[] args) {
			
		LinkedList list = new LinkedList();
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(15);
		Node n4 = new Node(2);
		Node n5 = new Node(24);
		Node n6 = new Node(60);
		
		list.addAllNode(n1,n2,n3,n4,n5,n6);
		list.traversalList();
		//step 1 : reverser the linked list
		list.reverseLinkedList();
		
		// maintain max and delete all node if it is less then max
		Node current = list.getHead();
		int max = current.data;
		Node previous = null;
		while(current != null && current.next != null){
			previous = current;
			current = current.next;
			if( max < current.data){
				max = current.data;
				continue;
			}
			while(max > current.data && current != null){
				current = current.next;
			}
			if(current == null){
				previous.next = null;
			}
			previous.next = current;
		}
		
		list.traversalList();
		
		// reverse the linked list
		list.reverseLinkedList();
		
	}
	
	
}
