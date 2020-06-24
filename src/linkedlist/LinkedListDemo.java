package linkedlist;


public class LinkedListDemo {




	public static void main(String[] args) {
		System.out.println("---------creating the linked list 10,20,15,2,24,60--------");
		LinkedList linkedList = new LinkedList();

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(15);
		Node n4 = new Node(2);
		Node n5 = new Node(24);
		Node n6 = new Node(60);

		//Node newNode1 = new Node(30);
		//Node newNode2 = new Node(30);

		linkedList.addAllNode(n1, n2, n3, n4, n5, n6);
		System.out.println("\n-------------------traversal the list list------------");
		linkedList.traversalList();


		//System.out.println("\n====reverseRecursiveTraversal===");
		//linkedList.reverseRecursiveTraversal(linkedList.getHead());


		//System.out.println("\n====recursiveTraversalList===");
		//linkedList.recursiveTraversalList(linkedList.getHead());


		//System.out.println("\n =====linked list length==="+ linkedList.getLength());
		//System.out.println("\n ===== get Kth Node , where k=3 and element is ::"+ linkedList.getNthNode(3));


		//linkedList.insertNodeatFirst(newNode1);
		//linkedList.insertNodeatLast(newNode2);



		//linkedList.insertNodeAfterGivenNode(n6, new Node(80));

		//linkedList.deleteNode(n6);


		//linkedList.deleteGivenNodeWithOutTraversing(n2);


		//linkedList.printMidNode();


		//linkedList.getNthNodeFromEnd(2);


		//linkedList.reverseLinkListWithGivenCount(3);

		//linkedList.isLoopInLinkedList();

		//linkedList.checkPalindrome();

		//linkedList.moveToFirst();

		//linkedList.deleteAlternativeNode();
		
		//linkedList.deleteList();

		//linkedList.printNthNodeFromEndRecursively(3);

	}

}
