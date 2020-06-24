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
		//temp is point to end of the Node
		temp.setNext(node);
	}

	public void addAllNode(Node... nodes) {
		for (Node node : nodes) {
			AddAtFirst(node);
		}
	}
	
	public void AddAtFirst(Node node){
		node.setNext(head);
		head = node;
	}

	public void AddBeforeGivenNode(Node givenNode, Node newNode){
		if(givenNode == null || head == null){
			System.out.println("The given previous node cannot be null");
	        return;
		}
		if(givenNode == head){
			 AddAtFirst(newNode);
			 return; 
		}
		Node previous = head;
		Node temp = previous.next;
		while(temp != null && temp.getData() != givenNode.data){
			previous = temp;
			temp = temp.next;
		}
		if(temp == null){
			return;
		}
		newNode.next= previous.next;
		previous.next = newNode;
	}
	
	public void AddAfterGivenNode(Node givenNode, Node newNode){	
		if(givenNode == null || head == null){
			System.out.println("The given previous node cannot be null");
	        return;
		}
		newNode.next = givenNode.next;
		givenNode.next = newNode;
	}
	
	public void AddAtLast(Node node){
		if(head == null){
			head = node;
			return;
		}
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		node.next = null;
		temp.next= node;
	}

	
	
	public void traversalList() {
		if (this.head == null) {
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " , ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	
	public void swapNodes(int x ,int y){
		
		// Nothing to do if x and y are same
        if (x == y) return;
		
     // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }
        
        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }
 
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
        
        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;
 
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;
        
     // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
        
		
		
	}
	
	
	public static void traversalList(Node node) {
		System.out.println();
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
	/**
	 * calculating length using iterative way
	 */
	public int getLength() {
		int length = 0;
		Node temp = this.head;
		while (temp != null) {
			length++;
			temp = temp.getNext();
		}
		return length;
	}

	/**
	 * calculating length recursive way
	 * 
	 **/
	public int getLengthRecursive(Node node) {

		if(node == null){
			return 0;
		}       
		return 1+ getLengthRecursive(node.next);
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
		return -1;
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
	
	
	public void deleteNodeAtGivenPosition(int position){
		
		if(head == null)
			return;
		if(position ==0){
			head = head.next;
			return;
		}
		Node temp = head ;
		for(int i= 1; (temp != null && i< position); i++ ){
		 temp = temp.next;	
		}
		// delete next node
		
		if(temp == null || temp.next == null){
			return;
		}
		// delete temp.next node
		temp.next = temp.next.next;
		traversalList();
	}
	

	/**
	 * Delete the first node of given list
	 */
	public void deleteFirstNode() {
		if(head == null){
			System.out.println("list is empty");
			return;
		}		
		head = head.next;
		traversalList();
	}
	
	public void deleteNode( Node node) {
		
		if(head == null){
			System.out.println("list is empty");
			return;
		}
		
		Node temp = this.head;		
		Node previousNode = null;
		
		// if deleting key is head itself
		if(temp.data == node.data){
			head = head.next;
		}
		// find the given key and maintain previous node reference
		while (temp != null && temp.getData() != node.getData()) {
			previousNode = temp;
			temp = temp.getNext();
		}
		if (temp == null) {
			System.out.println("Given key:" + node.getData()	+ " is not present in linked list ");
			return;
		}
		// delete current temp node
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
		 * Method 1: calculate the length (L) of the given linked list.
		 * * calculate the position of Node which is nth from end is L -N +1
		 */
		Node temp = head;
		int L = this.getLength();
		int givenNode = L - N +1 ;
		// we are in first node
		for (int count = 1; count < givenNode; count++) {
			temp = temp.getNext();

		}
		System.out.println("Nth from Last is::" + temp.getData());
		
		/**
		 * Method 2 (Use two pointers) Maintain two pointers ? reference pointer
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
			currentNode.next = prev;
			prev = currentNode;
			currentNode = nextNode;
		}
		this.head = prev;		
		System.out.println("\n after reverse linked list:: ");
		traversalList();
	}

	public void reverseLinkListWithGivenCount(int k){

		Node node = reverseLinkedList(head, k);
		head = node;
		System.out.println("after reverse:");
		traversalList(head);


	}


	
	public Node reverseLinkedList(Node startNode, int k) {
		Node prev = null;
		Node currentNode =startNode;
		Node nextNode = null;
		int count = 0;
		while (count < k && currentNode != null) {
			nextNode = currentNode.getNext();
			currentNode.next = prev;
			prev = currentNode;
			currentNode = nextNode;
			count++;
		}
		if(nextNode != null){
			startNode.next = reverseLinkedList(nextNode, k);
		}
		
		System.out.println("\n after reverse linked list:: ");
		return prev;
	}
	
	
	public void reverseLinkedListRecursive(){
		reverseLinkedListRecursive(null,head);
		System.out.println("\n after reverse linked list:: ");
		traversalList();
	}
	// initially previous will be null and current will be HEAD
	private void reverseLinkedListRecursive(Node previousNode, Node currentNode){
		
		// tail node check
		if(currentNode.next == null){
			head = currentNode;
			currentNode.next = previousNode;
			return ;
		}
		// Divide List into two part
		Node secondList = currentNode.next;
		currentNode.next = previousNode;
		
		reverseLinkedListRecursive(currentNode,secondList);
		
		
	}
	
	
	

	public boolean isLoopInLinkedList() {
		/* * Solution 1. traverse Node one by one and mark as a visited, and check
		 * whether Node is marked or not. if yes, that means there is a loop in
		 * the linked link list 	 
		
		 * Solution 2. Floyd?s Cycle-Finding Algorithm: This is the fastest
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
		
		if(head.data > node.data){
			node.next = head;
			this.head = node;
			return;
		}
		
		while (temp != null && node.getData() > temp.getData()) {
			//System.out.println(temp.getData());
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
	
	/*public void pairWiseSwapNodes() {
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
			temp = temp.getNext();
		}
		System.out.println("\n After pairWiseSwap ");
		traversalList();
	}*/
	
	
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
	 We know that Floyd?s Cycle detection algorithm terminates when fast and
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
	/**
	 *  Recursive sorted merge 
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
	
	public boolean searchDateOnListRecursive(Node node, int data) {
		if(node==null){
			return false;
		}
		if(node.getData()==data){
			return true;
		}
		return searchDateOnListRecursive(node.getNext(),data);
	}

	public void rotateByK(int k) {

		if(k == 0)
			return ;
		
		Node current = this.head;
		int count =1;
		while(count < k && current != null){
			current =current.next;
			count ++;
		}
		//System.out.println(" count "+ count);
		//System.out.println(" current "+ current.data);
		if(current == null){
			return;
		}
		// store kthNode to make last node.
		Node kthNode = current;
		while(current.next != null){
			current = current.next;
		}
		// now current is last node;
		// add next node as first node
		current.next = head;
		head = kthNode.next;
		kthNode.next = null;
		System.out.println("After rorated by k , list is: ");
		this.traversalList();
	}

	public void printNthNodeFromEndRecursively(int k) {
		printNthNodeFromEndRecursively(head,k);
	}

	public int printNthNodeFromEndRecursively(Node node , int k){

		if(node == null){
			return 0;
		}
		int  number = 1 + printNthNodeFromEndRecursively(node.getNext(), k);
		if(k ==number){
			System.out.println(node.getData());
		}
		return number;

	}

}
