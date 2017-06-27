package tree;

//The diameter of a tree (sometimes called the width) is the number of nodes on the longest 
//path between two leaves in the tree
public class BinarySerachTree3_DiameterExample {
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree(new Node(30));
		bst.addMultipleNode( new Node(10), new Node(40),
				new Node(45), new Node(35), new Node(25), new Node(5),
				new Node(7), new Node(4), new Node(26),new Node(27), new Node(28), new Node(29),
		new Node(3), new Node(2),new Node(1)
		);

		
		System.out.println("Diameter of the tree====");
		System.out.println(bst.diameterOfBinaryTree(bst.getRoot()));
		
	}

}
