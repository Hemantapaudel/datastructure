package linkedlist;

import java.util.Stack;
/**
 * 1. Array store elements in continuous  memory and linked list store in random
 * 2. Array are static and linked list are dynamic size
 * 3. In array random access is possible not like linked list
 * 4.  In array  insertion and deletion having high cost
 * 
 *
 */
public class LinkedList {
	Node head;

	public Node getHead() {
		return this.head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public LinkedList() {
		this.head = null;
	}
	
	public LinkedList(Node ...nodes){
		this.addAllNode(nodes);
	}

	public void addNode(Node node) {

		if (head == null) {
			head = node;
			return;
		}
		Node temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(node);
	}

	public void addAllNode(Node... nodes) {
		for (Node node : nodes) {
			addNode(node);
		}
	}

	

	public void traversalList() {
		if (this.head == null) {
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " , ");
			temp = temp.getNext();
		}
	}

	
	public static void traversalList(Node node) {
		if (node == null) {
			return;
		}
		Node temp = node;
		while (temp != null) {
			System.out.print(temp.getData() + " , ");
			temp = temp.getNext();
		}
	}

	public void reverseRecursiveTraversal(Node temp) {
		if (temp == null) {
			return;
		}
		reverseRecursiveTraversal(temp.getNext());
		System.out.print(temp.getData() + " , ");
	}

	public void recursiveTraversalList(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.getData() + " , ");
		recursiveTraversalList(head.getNext());
	}

	public int getLength() {
		int length = 0;
		Node temp =this. head;
		while (temp != null) {
			length++;
			temp = temp.getNext();
		}
		return length;
	}

	public int getNthNode( int k) {
		int count = 0;
		Node temp = this.getHead();
		while (temp != null) {
			count++;
			if (count == k) {
				return temp.getData();
			}
			temp = temp.getNext();
		}
		return 0;
	}

	public void insertNodeatFirst(Node newNode) {
		System.out.print("=====after insert node "+ newNode.getData() + " at first :");
		newNode.setNext(head); 
		this.head = newNode;
		traversalList(this.head);

	}

	public void insertNodeatLast( Node newNode) {
		System.out.print("\n=====after insert node "+ newNode.getData() + " at last :");
		newNode.setNext(null); 
		Node temp = head;
		if (temp == null) {
			this.head = newNode;
		}

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
		
		traversalList(this.head);
	}

	public void insertNodeAfterGivenNode( Node givenNode, Node newNode) {
		Node temp = this.head;
		if (givenNode == null || head == null || newNode == null) {
			System.out.println("Node is NULL");
			return;
		}
		while (temp != null) {
			if (temp.getData() == givenNode.getData()) {
				newNode.setNext(temp.getNext());
				temp.setNext( newNode);
				break;
			}
			temp = temp.getNext();
		}
		System.out.println("\n == after insert new element "+newNode.getData() +" after given element "+givenNode.getData());
		traversalList();
	}
	
	
	public void deleteNode( Node node) {
		Node temp = this.head;		
		Node previousNode = null;
		while (temp != null && temp.getData() != node.getData()) {
			previousNode = temp;
			temp = temp.getNext();
		}
		if (temp == null) {
			System.out.println("Given key:" + node.getData()	+ " is not present in linked list ");
			return;
		}
		previousNode.setNext( temp.getNext());
		System.out.println("\n===after delete element "+node.getData() + " from list :");
		traversalList();
	}

	
	public void deleteGivenNodeWithOutTraversing(Node givenNode) {
		if (givenNode == null) {
			System.out.println("Given Node is Null");
			return;
		}
		// if given element is last element
		if (givenNode.getNext() == null) {
			// please think about it
			return;
		}
		// copy the next element data to given element and delete next node
		System.out.println(" \n after delete element "+givenNode.getData()+ ", list is ");
		Node temp = givenNode.getNext();
		givenNode.setData(temp.getData());
		givenNode.setNext( temp.getNext());
		traversalList();
	}

	
	public void printMidNode() {
		if (head == null) {
			System.out.println("Given linked list is empty");
			return;
		}
		Node temp_slow = head;
		Node temp_fast = head;
		while (temp_fast != null && temp_fast.getNext() != null) {
			temp_slow = temp_slow.getNext();
			temp_fast = temp_fast.getNext().getNext();
		}
		System.out.println("\n Middle Node of given Linked List is:"	+ temp_slow.getData());
	}

	public void getNthNodeFromEnd( int N) {
		/**
		 * Method 1: calculate the length (L) of the given linked list.  * calculate the position of Node which is nth from end is (L-n+1)
		 */
		Node temp = head;
		int L = this.getLength();
		int givenNode = L - N + 1;
		// we are in first node
		for (int count = 1; count < givenNode; count++) {
			temp = temp.getNext();
		}
		System.out.println("Nth from Last is::" + temp.getData());
		
		/**
		 * Method 2 (Use two pointers) Maintain two pointers – reference pointer
		 * and main pointer. Initialize both reference and main pointers to
		 * head. First move reference pointer to N nodes from head. Now move
		 * both pointers one by one until reference pointer reaches end. Now
		 * main pointer will point to nth node from the end. Return main pointer
		 */
		Node mainPointer = head, referencePointer = head;
		for (int count = 1; ((count < N) && (referencePointer != null)); count++) {
			referencePointer = referencePointer.getNext();
		}
		if (referencePointer == null) {
			System.out.println(" List is shorter than given N");
			return;
		}
		//stop when ref pointing last node
		while (referencePointer.getNext() != null) {
			referencePointer = referencePointer.getNext();
			mainPointer = mainPointer.getNext();
		}
		System.out.println("Using 2 pointer, Nth from Last is ::"+ mainPointer.getData());
	}
	
	

	public void reverseLinkedList() {
		Node prev = null;
		Node currentNode =this. head;
		Node nextNode;
		while (currentNode != null) {
			nextNode = currentNode.getNext();
			currentNode.setNext(prev);  ;
			prev = currentNode;
			currentNode = nextNode;
		}
		this.head = prev;		
		System.out.println("\n after reverse linked list:: ");
		traversalList();
	}
	
	

	public boolean isLoopInLinkedList() {
		/* * Solution 1. traverse Node one by one and mark as a visited, and check
		 * whether Node is marked or not. if yes, that means there is a loop in
		 * the linked link list 	 
		
		 * Solution 2. Floyd’s Cycle-Finding Algorithm: This is the fastest
		 * method. Traverse linked list using two pointers. Move one pointer by
		 * one and other pointer by two. If these pointers meet at some node
		 * then there is a loop
		 * .*/
		Node slow_PTR = head;
		Node fast_PTR = head;
		while (fast_PTR != null && fast_PTR.getNext() != null) {
			slow_PTR = slow_PTR.getNext();
			fast_PTR = fast_PTR.getNext().getNext();
			if (fast_PTR == slow_PTR) {
				System.out.println("\nBhai List me Loop h be");
				return true;
			}
		}
		System.out.println("\n Bhai List me Loop nhi h be ");
		return false;
	}
	
	

	
	public boolean checkPalindrome() {
		Stack<Integer> s = new Stack<Integer>();
		Node temp = head;
		while (temp != null) {
			s.push(temp.getData());
			temp = temp.getNext();
		}
		temp = head;
		while (temp != null) {
			if (!(s.pop() == temp.getData())) {
				System.out.println("Given Linked list is NOT PALINDROME");
				return false;
			}
			temp = temp.getNext();
		}
		System.out.println("Given Linked list is  PALINDROME");
		return true;
	}


	void sortedInsert(Node head, Node node) {
		Node temp = head;
		Node previousNode = head;
		if (head == null) {
			this.head = node;
			node.setNext(null); ;
			return;
		}
		while (temp != null && node.getData() > temp.getData()) {
			previousNode = temp;
			temp = temp.getNext();
		}
		previousNode.setNext(node);
		node.setNext(temp);
	}

	
	public int getLength(Node head) {
		int length = 0;
		Node temp =head;
		while (temp != null) {
			length++;
			temp = temp.getNext();
		}
		return length;
	}
	
	 
	/**
	 * Method 1(Simply use two loops)
     *  Use 2 nested for loops. Outer loop will be for each node of the 1st list and inner loop will be
     *   for 2nd list. In the inner loop, check if any of nodes of 2nd list is same as the current node of 
     *   first linked list. Time complexity of this method will be O(mn) where m and n are the number of
     *    nodes in two lists.
     *    
     * Method 2 (Mark Visited Nodes)
     *    
     * Method 3(Using difference of node counts)
     *    
	 */
	public void printIntersectionOfTwoList(Node head1, Node head2) {
		
		int first = getLength(head1);
		int second = getLength(head2);
		System.out.println("\n first list length = " + first + " second list length =" + second);
		int count = Math.abs(first-second);
		System.out.println("----count ---"+count);
		if (first > second) {
			while (count > 0) {
				count--;
				head1 = head1.getNext();
			}
		} else {
			while (count > 0) {
				count--;
				head2 = head2.getNext();
			}
		}
		System.out.println("After changing the location of the head pointers");
		System.out.println("First head data=" + head1.getData() + "  second  head data=" + head2.getData());
		while (head1 != null && head2 != null) {
			// the intersection node should be same
			if ( head1 ==  head2) {
				System.out.println("  and Intersection point is :::" + head1.getData());
				break;
			}
			head1 = head1.getNext();
			head2 = head2.getNext();
		}
	}
	
	

	public void deleteDuplicatesFromSortedList() {
		System.out.println(" \n before deleteDuplicatesFromSortedList ");
		traversalList();
		
		Node temp = this.head;
		if (temp == null) {
			System.out.println("Given List is Empty");
			return;
		}
		while (temp != null && temp.getNext() != null) {
			Node nextNode = temp.getNext();
			if (temp.getData() == nextNode.getData()) {
				// remove next element
				temp.setNext(nextNode.getNext());
			} else {
				temp = temp.getNext();
			}
		}
		System.out.println(" \nAfter deleteDuplicatesFromSortedList ");
		traversalList();
	}

	
	public void pairWiseSwap() {
		System.out.println(" \n Before pairWiseSwap ");
		traversalList();
		Node temp = head;
		if (temp == null) {
			System.out.println("Given List is Empty");
			return;
		}
		while (temp != null && temp.getNext() != null) {
			swapData( temp,  temp.getNext());
			temp = temp.getNext().getNext();
		}
		System.out.println("\n After pairWiseSwap ");
		traversalList();
	}
	
	private void swapData(Node first, Node second){
		int a = first.getData();
		first.setData(second.getData());
		second.setData( a);
	}
	
	public void pairWiseSwapNodes() {
		System.out.println(" \n Before pairWiseSwap ");
		traversalList();
		Node temp = head;
		if (temp == null) {
			System.out.println("Given List is Empty");
			return;
		}
		Node previousNode =temp;
		while (temp != null && temp.getNext() != null) {
			previousNode.setNext(temp.getNext());
			temp.setNext(temp.getNext().getNext());
			previousNode= temp;
			temp.getNext();	
		}
		System.out.println("\n After pairWiseSwap ");
		traversalList();
	}
	
	
	/**
	 * move last element to first 
	 */
	public void moveToFirst() {
		Node temp = head;
		//stop when process second last element
		while (temp.getNext().getNext() != null) {
			temp = temp.getNext();
		}
		temp.getNext().setNext(head);
		this.head = temp.getNext();
		temp.setNext(null);
		System.out.println("\n After moveToFirst ");
		traversalList();
	}

	public void sortedIntersect(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;

		Node head3 = null;
		Node temp3 = null;

		while (temp1 != null && temp2 != null) {
			if (temp1.getData() == temp2.getData()) {
				if (head3 == null) {
					head3 = new Node(temp1.getData());
					temp3 = head3;
				} else {
					Node n = new Node(temp1.getData());
					temp3.setNext( n);
					temp3 = temp3.getNext();
				}
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
			} else if (temp1.getData() < temp2.getData()) {
				temp1 = temp1.getNext();
			} else {
				temp2 = temp2.getNext();
			}
		}
		System.out.println("\n------Printing interset of two list::------\n");
		traversalList(head3);
	}

	
	void deleteAlternativeNode() {
		Node previous = getHead();
		Node temp = previous.getNext();
		while (previous != null && temp != null) {
			previous.setNext(temp.getNext());
			previous = previous.getNext();
			if (previous != null) {
				temp = previous.getNext();
			}
		}
		System.out.println("\n------ After deleteAlternativeNode ::------\n");
		this.traversalList();
	}


	/**
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public Node reverseWithGroupK(Node head, int k) {
		Node current = head;
		Node nextPTR = null;
		Node prevPTR = null;
		int count = 0;
		while (current != null && count < k) {
			count++;
			nextPTR = current.getNext();
			current.setNext(prevPTR);
			prevPTR = current;
			current = nextPTR;
		}
		if (nextPTR != null) {
			head.setNext( reverseWithGroupK(nextPTR, k));
		}
		return prevPTR;
	}

	/**
	 * 
	 We know that Floyd’s Cycle detection algorithm terminates when fast and
	 * slow pointers meet at a common point. We also know that this common point
	 * is one of the loop nodes. We store the address of this in a pointer
	 * variable say ptr2. Then we start from the head of the Linked List and
	 * check for nodes one by one if they are reachable from ptr2. When we find
	 * a node that is reachable, we know that this node is the starting node of
	 * the loop in Linked List and we can get pointer to the previous of this
	 * node
	 */
	
	public boolean detectAndRemoveLoop(Node head) {
		boolean isLoopFound = false;
		Node slow_PTR = head;
		Node fast_PTR = head;
		while (fast_PTR != null && fast_PTR.getNext() != null) {
			slow_PTR = slow_PTR.getNext();
			fast_PTR = fast_PTR.getNext().getNext();
			if (fast_PTR == slow_PTR) {
				System.out.println("\nBhai List me Loop h be");
				isLoopFound = true;
				break;
			}
		}
		Node prevPTR = slow_PTR;
		if (isLoopFound) {
			fast_PTR = head;
			System.out.println("fast_PTR==" + fast_PTR.getData() + "slow_PTR=="	+ slow_PTR.getData());
			while (fast_PTR != slow_PTR) {
				prevPTR = slow_PTR;
				slow_PTR = slow_PTR.getNext();
				fast_PTR = fast_PTR.getNext();
			}
			System.out.println("fast_PTR==" + fast_PTR.getData() + "slow_PTR=="	+ slow_PTR.getData() + "Last node is:" + prevPTR.getData());
			// setting null in next pointer of last node.
			prevPTR.setNext( null);
		}
		return isLoopFound;
	}

//	---------------------------------------------------------------------------------
//	MergeSort(headRef)
//	1) If head is NULL or there is only one element in the Linked List 
//	then return.
//	2) Else divide the linked list into two halves.  
//	using slow and fast pointer. 
//	3) Sort the two halves a and b.
//	MergeSort(a);
//	MergeSort(b);
//	4) Merge the sorted a and b (using SortedMerge() ) 
//	and update the head pointer using headRef.
//	this.head = sortedMerge(a, b);
//	------------------------------------------------------------------------------------
//	
	
	public void mergeSort(Node headRef) {
		if (headRef == null || headRef.getNext() == null) {
			return;
		}
		Node a, b;
		Node temp_slow = headRef;
		Node temp_fast = headRef.getNext();
		while (temp_fast != null) {
			temp_fast = temp_fast.getNext();
			if (temp_fast != null) {
				temp_slow = temp_slow.getNext();
				temp_fast = temp_fast.getNext();
			}
		}
		a = headRef;
		b = temp_slow.getNext();
		temp_slow.setNext(null);
		mergeSort(a);
		mergeSort(b);
		// merging the sorted list into one.
		this.head = sortedMerge(a, b);

	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Node sortedMerge(Node a, Node b) {
		Node result = null;
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		if (a.getData() < b.getData()) {
			result = a;
			result.setNext(  sortedMerge(a.getNext(), b) );
		} else {
			result = b;
			result.setNext(  sortedMerge(a, b.getNext()));
		}
		System.out.println();
		traversalList(result);
		return result;
	}


	public void deleteList() {
		Node current = this.head;
		Node nextNode;
		while (current != null) {
			nextNode = current.getNext();
			current.setNext(null);
			current = nextNode;
		}
		this.head =null;
	}
	
	
	
	
	/**
	 *  Recursive function on linked list
	 */
	public int getLengthRecusive(Node node) {
		if(node ==null){
			return 0;
		}
		return 1+getLengthRecusive(node.getNext());
	}
	
	
	public boolean searchDateOnListRecursive(Node node, int data) {
		if(node==null){
			return false;
		}
		if(node.getData()==data){
			return true;
		}
		return searchDateOnListRecursive(node.getNext(),data);
	}
}
