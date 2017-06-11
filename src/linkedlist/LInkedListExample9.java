package linkedlist;
/**
 * 
 * Rotate a Linked List
 *  Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is 
 *  a given positive integer. For example, if the given linked list is 10->20->30->40->50->60 
 *  and k is 4, the list should be modified to 50->60->10->20->30->40. Assume that k is 
 *  smaller than the count of nodes in linked list.
 */
public class LInkedListExample9 {
	public static void main(String[] args) {

		LinkedList linkedList = LinkedListUtils.creatList(new int[]{10,20,30,40,50,60}); 
		
		linkedList.rotateByK(4);
		
	}

}
