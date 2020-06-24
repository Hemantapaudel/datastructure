package tree;

import java.util.Stack;

public class BinarySearchTree4_InOrderTraversal {

	// print tree in sort order traversal
	//inorder traversal using recursive
	public static void inOrderTraversalRecursive(Node root){
		if(root != null){
			inOrderTraversalRecursive(root.getLeft());
			System.out.println(root.getData());
			inOrderTraversalRecursive(root.getRight());
		}
	}

	// print tree in sort order traversal
	//inorder traversal using stack
	public static void InOrderTraversalUsingStack(Node root){
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		//first node to be visited will be the left one
		while(node != null){
			stack.push(node);
			node = node.getLeft();
		}
		 // traverse the tree
		while( ! stack.isEmpty()){
			node = stack.pop();
			System.out.println(node.getData());
			if(node.getRight() !=  null ){
				node = node.getRight();
				while(node != null){
					stack.push(node);
					node = node.getLeft();
				}
			}
		}
		
	}


	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(new Node(30));
		bst.addMultipleNode( new Node(10), new Node(40),
				new Node(45), new Node(35), new Node(25), new Node(5),
				new Node(7), new Node(4) );
		
		
		BinarySearchTree4_InOrderTraversal.InOrderTraversalUsingStack(bst.getRoot());
	}

}
