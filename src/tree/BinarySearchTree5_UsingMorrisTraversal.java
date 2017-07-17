package tree;
/**
 * 
 * Using Morris Traversal, we can traverse the tree without using stack and recursion.
 *  The idea of Morris Traversal is based on Threaded Binary Tree. In this traversal,
 *   we first create links to Inorder successor and print the data using these links, 
 *   and finally revert the changes to restore original tree.

1. Initialize current as root 
2. While current is not NULL
   If current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Make current as right child of the rightmost 
         node in current's left subtree
      b) Go to this left child, i.e., current = current->left
 */
public class BinarySearchTree5_UsingMorrisTraversal {

	void MorrisTraversal(Node root) {
        Node current, pre;
        
        current = root;
        while(current != null){
        	if(current.getLeft() == null){
        		System.out.println(current.getData());
        		current = current.getRight();
        	}else{
        		/* Find the inorder predecessor of current */
                pre = current.getLeft();
                while (pre.getRight() != null && pre.getRight() != current) 
                    pre = pre.getRight();
        	
                /* Make current as right child of its inorder predecessor */
                if (pre.getRight() == null){
                	//created threaded tree
                    pre.setRight(current);
                    current = current.getLeft();
                }else{
                	// restore tree from threaded tree
                	pre.setRight(null); 
                    System.out.print(current.getData() + " ");
                    current = current.getRight();
                }
        	}
        }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
