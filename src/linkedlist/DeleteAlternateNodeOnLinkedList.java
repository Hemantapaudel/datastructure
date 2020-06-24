package linkedlist;

public class DeleteAlternateNodeOnLinkedList {
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

		Node result = deleteAlternateNode(list.getHead());
		LinkedList.traversalList(result);

	}
	
	
	public static Node deleteAlternateNode(Node head){
		if(head == null || head.next ==null){
			return head;
		}
		
		Node temp = head ;
		while(temp != null &&  temp.next != null){
			temp.next = temp.next.next;	
			temp = temp.next;
		}
		return head;
		
		
	}
	
	

}
