package linkedlist;

public class MergeTwoSortedLinkedList {
	public static void main(String[] args) {
		
		Node node1 = new Node(10);
		Node node2 = new Node(20);
		Node node3 = new Node(30);
		Node node4 = new Node(40);
		Node node5 = new Node(50);
		LinkedList sortedLinkedList1 = new LinkedList(node1, node2, node3, node4, node5);
		System.out.println("\n first sorted list: ");
		sortedLinkedList1.traversalList();
		
		Node node20 = new Node(15);
		Node node21 = new Node(22);
		Node node22 = new Node(25);
		Node node23 = new Node(28);
		Node node24 = new Node(29);

		LinkedList sortedLinkedList2 = new LinkedList(node20, node21, node22, node23, node24);
		System.out.println("\n second sorted list: ");
		sortedLinkedList2.traversalList();

		Node sorLinkedListHead = new LinkedList().sortedMerge(sortedLinkedList1.getHead(),	sortedLinkedList2.getHead());
		System.out.println("\n Merged Result  sorted list: ");
		LinkedList.traversalList(sorLinkedListHead);
		
		LinkedList list = new LinkedList(sorLinkedListHead);
		System.out.println();
		list.traversalList();
		
		
		System.out.println("Result list length = "+list.getLengthRecusive(sorLinkedListHead));

		System.out.println("27 found  list= "+list.searchDateOnListRecursive(sorLinkedListHead,27));
		System.out.println("30 found  list= "+list.searchDateOnListRecursive(sorLinkedListHead,30));
		


	}

}
