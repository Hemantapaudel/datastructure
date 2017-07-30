package linkedlist;

public class LinkedListUtils {
	
	public static LinkedList creatList(int []numbers){
		LinkedList list = new LinkedList();
		for(int  number : numbers){
			Node node = new Node(number);
			list.AddAtLast(node);
		}
		return list;
	}
	
	// recursive sortedMerge
	public static Node sortedMerge(Node a, Node b) {
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
		return result;
	}
	

	public static Node sortedMergeIteratively(Node a, Node b) {
	
		if(a == null){
			return b;
		}
		if(b == null){
			return a;
		}
		
		Node dummyHead = null;
		Node dummyResult = null;
		
		Node firstListNode = a;
		Node secondListNode = b;
		if(firstListNode.data> secondListNode.data){
			dummyHead = b;
			secondListNode = secondListNode.next; 
		}else{
			dummyHead =a;
			firstListNode = firstListNode.next;
		}
		dummyResult = dummyHead;
		
		
		while(firstListNode != null   &&  secondListNode != null){
			if(firstListNode.data > secondListNode.data){
				dummyResult.next = secondListNode;
				secondListNode = secondListNode.next;
			}else{
				dummyResult.next = firstListNode;
				firstListNode = firstListNode.next;
			}
			dummyResult = dummyResult.next;
		}
		
		
		if(firstListNode == null){
			while (secondListNode != null){
				dummyResult.next = secondListNode;
				secondListNode = secondListNode.next;
			}
		}else{
			while (firstListNode != null){
				dummyResult.next = firstListNode;
				firstListNode = firstListNode.next;
			}
		}
	return dummyHead;
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
//	 O(n Log n)
//	------------------------------------------------------------------------------------
//	
	
	public static Node mergeSort(Node headRef) {
		if (headRef == null || headRef.getNext() == null) {
			return headRef;
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
		 return sortedMerge(a, b);

	}

	
	
	public static Node addTwoLists(Node first , Node second){
		 Node result  = null; 
		 Node previousNode = null;
		 int carry =0;
		 int sum =0;
		 while(first != null || second != null){
			 sum = carry + (first !=null ? first.data:0) + (second !=null ? second.data:0);
			 carry = (sum >10)?1:0;
			 sum = sum %10;
			 Node temp = new Node(sum);
			 
			 //creating new list for the result
			 if(result == null){
				 result = temp;
			 }else{
				 previousNode.next = temp;
			 }
			 previousNode = temp;
			 
			 first = first != null ? first.next : null;
			 second = second != null ? second.next : null;
		 }
		 
		 if(carry >0){
			 previousNode.next = new Node(carry);
		 }
		 return result;
	}
	
	
	public static void printList(Node node){
		System.out.println();
		
		while (node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		} 
		System.out.println();
		
	}
	

}
