package linkedlist;

/**
 * In singly linked list, the next pointer of the last node points to the first node which is called as Circular linked list
 * 
 */
public class CircularList {

	private Node head;

	public Node getHead() {
		return this.head;
	}

	public void addNode(Node node) {
		if (head == null) {
			head = node;
			node.setNext(head);
			return;
		}
		Node temp = head;
		
		while (temp.getNext() != head) {
			temp = temp.getNext();
		}
		temp.setNext( node);
		node.setNext(head);
	}

	public void addAllNode(Node... nodes) {
		for (Node node : nodes) {
			addNode(node);
		}
	}

	public void traversCircularList() {
		if (head == null) {
			return;
		}
		Node temp = head;
		do {
			System.out.print(temp.getData() + " , ");
			temp = temp.getNext();
		} while (temp != head);
	}

	public void spiteCircularListToLinearList() {
		if(this.head ==null){
			return;
		}
		Node temp = head;
		while (temp.getNext() != head) {
			temp = temp.getNext();
		}
		temp.setNext( null);
		traversalList(head);
	}

	public void traversalList(Node head) {
		System.out.println();
		if (head == null) {
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getNext() + " , ");
			temp = temp.getNext();
		}
		System.out.println();
	}

}
