package linkedlist;


/**
 *Q1.Merge two sorted linked lists
 *
 * Q2. Merge Sort for Linked Lists
 *
 */
public class LinkedListExample5 {

	public static void main(String[] args) {
		LinkedList listA = LinkedListUtils.creatList(new int[]{5,10,15,20,25,30,35,40,45,50});
		LinkedList listB = LinkedListUtils.creatList(new int[]{2,12,17,21,22,23,31,42,47,57});
		
	// using recursive	
	Node resultHead =	LinkedListUtils.sortedMergeIteratively(listA.getHead(),listB.getHead());
	LinkedList.traversalList(resultHead);	
	
	System.out.println("\n=======merge sort=====");
	LinkedList listC = LinkedListUtils.creatList(new int[]{5,10,15,20,19,14,35,40,45,50});
	Node mergeSortResult =	LinkedListUtils.mergeSort(listC.getHead());
	LinkedList.traversalList(mergeSortResult);	
	
		
	}

}
