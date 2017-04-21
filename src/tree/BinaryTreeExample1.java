package tree;

public class BinaryTreeExample1 {
	
	public static void main(String[] args) {
	BinarySearchTree bst = new BinarySearchTree(new Node(30));
	bst.addMultipleNode( new Node(10), new Node(40),
			new Node(45), new Node(35), new Node(25), new Node(5),
			new Node(7), new Node(4) );

	System.out.println("\n ==== PreOrder traversal ");
	bst.preOrderTraversal();
    System.out.println("\n==== Inorder traversal ");
    bst.inOrderTraversal();
    System.out.println("\n ==== PostOrder traversal ");
    bst.postOrderTraversal();
    
    System.out.println("\n BFS traversal ");
    bst.BFS();
    
    System.out.println("\n DFS traversal ");
    bst.DFS();
    
    System.out.println("max element form Binary search tree: "+ bst.maxElementInBSTTree());
    System.out.println("max element using BFS traversal: "+ bst.findMaxUsingBFS());
    System.out.println("max element using BFS traversal: "+ bst.serchingUsingBFS(45));
    
     
    BinarySearchTree bst1 = new BinarySearchTree(new Node(30));
	bst1.addMultipleNode( new Node(10), new Node(40),new Node(45), new Node(35));
	bst1.printPath(bst1.getRoot());
	
	
	bst.printVerticalOrder();
	bst.maxSumOfLevel();
    
    
    
    
	}
}
