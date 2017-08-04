package linkedlist;


public class IntersetOfTwoSortedLinkedList {
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

		LinkedList list2 = new LinkedList();

		list2.addNode(new Node(10));
		list2.sortedInsert(list2.getHead(), new Node(20));
		list2.sortedInsert(list2.getHead(), new Node(30));
		list2.sortedInsert(list2.getHead(), new Node(40));
		list2.sortedInsert(list2.getHead(), new Node(35));

		Node result = sortedInterset(list.getHead(), list2.getHead());
		LinkedList.traversalList(result);

	}

	public static Node sortedInterset(Node a, Node b) {
		if (a == null || b == null) {
			return null;
		}
		if (a.data > b.data) {
			return sortedInterset(a, b.next);
		} else if (a.data < b.data) {
			return sortedInterset(a.next, b);
		} else {
			Node node = new Node(a.data);
			node.next = sortedInterset(a.next, b.next);
			return node;
		}
	}
}
