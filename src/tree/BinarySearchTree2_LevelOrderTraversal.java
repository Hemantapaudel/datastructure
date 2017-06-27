package tree;

public class BinarySearchTree2_LevelOrderTraversal {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(new Node(30));
		bst.addMultipleNode( new Node(10), new Node(40),
				new Node(45), new Node(35), new Node(25), new Node(5),
				new Node(7), new Node(4) );

		
		System.out.println("Level order traversal using recursive call===="); 
		int height = bst.getHeight(bst.getRoot());
		System.out.println("====height=="+height);
		
		for(int i =1 ; i<= height;i++){
		System.out.println("======Level:"+i+"======");
		bst.printNthLevelNodes(bst.getRoot(), i);
		}
		
		System.out.println("=======Level order traversal using queue ");
		bst.BFS();

	}

}
