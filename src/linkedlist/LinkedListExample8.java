package linkedlist;
/**
 * 
 * @author Hemanta
 * 
 * Add two numbers represented by linked lists | Set 1
 * Given two numbers represented by two lists, write a function that returns sum list. 
 * 
 * Example 1
 * 	Input:
 *   First List: 5->6->3  // represents number 365
 *   Second List: 8->4->2 //  represents number 248
 *   
 *   Output
 *    Resultant list: 3->1->6  // represents number 613 
 *
 */
public class LinkedListExample8 {
	public static void main(String[] args) {

		LinkedList listA = LinkedListUtils.creatList(new int[]{5,2,1}); // 125
		LinkedList listB = LinkedListUtils.creatList(new int[]{2,1,3});//312
		
		
	   Node node =	LinkedListUtils.addTwoLists(listA.getHead(),listB.getHead());
	   LinkedListUtils.printList(node);//437
	   
	   
		
		
	}

}
