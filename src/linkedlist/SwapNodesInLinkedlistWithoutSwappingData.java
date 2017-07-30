package linkedlist;


/**
 *
 * 1. Swap nodes in a linked list without swapping data
 * Given a linked list and two keys in it, swap nodes for two given keys.
 * Nodes should be swapped by changing links. Swapping data of nodes may be expensive
 * in many situations when data contains many fields.
 * 
 * 2. Reverse the linked list 
 *
 */
public class SwapNodesInLinkedlistWithoutSwappingData {
	public static void main(String[] args) {		
		int []numbers = {5,10,15,20,25,30,35,40,45,50};
		LinkedList list = LinkedListUtils.creatList(numbers);
		list.traversalList();
		
		
		list.swapNodes(10,20);
		list.traversalList();
		
		//Iterative way
		list.reverseLinkedList();
		
		list.reverseLinkedListRecursive();
		
		
		
		
	}

}
