package linkedlist;

public class CheckLoopExistOnLinkedList {
	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(15);
		Node n4 = new Node(2);
		Node n5 = new Node(24);
		//creating loop
		Node n6 = new Node(60,n3);

		linkedList.addAllNode(n1, n2, n3, n4, n5, n6);
		System.out.println("\n------traversal the list list------------");
		

		Boolean isLoopExist = linkedList.isLoopInLinkedList();
		if(isLoopExist){
			linkedList.detectAndRemoveLoop(linkedList.getHead());
		}
		System.out.println(" ");
		linkedList.traversalList();
		
	}

}
