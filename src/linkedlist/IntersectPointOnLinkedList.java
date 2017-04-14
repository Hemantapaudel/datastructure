package linkedlist;

public class IntersectPointOnLinkedList {
	public static void main(String[] args) {
		Node n11 = new Node(10);
		Node n12 = new Node(20);
		Node n13 = new Node(15);
		Node n14 = new Node(2);
		Node n15 = new Node(24);
		Node n16 = new Node(60);
		System.out.println(n16.hashCode());

		Node n112 = new Node(14);
		Node n113 = new Node(24);
		Node n114 = new Node(34);
		Node n115 = new Node(34);
		Node n116 = new Node(44);
		Node n117 = new Node(44);

		Node n118 = new Node(74);
		Node n119 = new Node(84);

		LinkedList linkedList1 = new LinkedList();
		linkedList1.addAllNode(n11, n12, n13, n14, n15, n16);
		LinkedList linkedList2 = new LinkedList();
		linkedList2.addAllNode(n112, n113, n114, n115, n116, n117, n16, n118,n119);
		
		linkedList1.traversalList();
		System.out.println("\nInterset point is "+n16.getData());
		linkedList2.traversalList();
		
		new LinkedList().printIntersectionOfTwoList(linkedList1.getHead(),linkedList2.getHead());
		
		
	}
}
