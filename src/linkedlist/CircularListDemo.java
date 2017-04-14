package linkedlist;


public class CircularListDemo {

	public static void main(String[] args) {
		CircularList circularList = new CircularList();
		
		
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		
		circularList.addAllNode(n1,n2,n3,n4);
		circularList.traversCircularList();
	    circularList.spiteCircularListToLinearList();

	}

}
