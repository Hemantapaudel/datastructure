package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BinarySearchTree {
	
	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public BinarySearchTree(Node node) {
		this.root= node;
	}
	
	/**
	 * this method add the Node in Tree as BST rule i.e left node should have
	 *
	 * smaller and right node should have equal or greater than root value.
	 */
	public static void addNode(Node root, Node node) {
		if (node == null) {
			return;
		}
		if(root == null){
			root = node;
		   return;
		}
		if (root.getData() > node.getData()) {
			addNodeOnLeft(root, node);
		} else {
			addNodeOnRight(root, node);
		}
	}

	private static void addNodeOnRight(Node root, Node node) {
		if (root.getRight() == null) {
			root.setRight(node);
		} else {
			addNode(root.getRight(), node);
		}
	}

	private static void addNodeOnLeft(Node root, Node node) {
		if (root.getLeft() == null) {
			root.setLeft(node);
		} else {
			addNode(root.getLeft(), node);
		}
	}

	
	public void addMultipleNode(Node... ns) {
		for (Node n : ns) {
			addNode(this.root, n);
		}
	}

	public void preOrderTraversal(){
		Node currentNode = root;
		preOrderTraversal(currentNode);
	}
	private void preOrderTraversal(Node currentNode){
		if(currentNode != null){
			System.out.print("  "+ currentNode.getData());
			preOrderTraversal(currentNode.getLeft());
			preOrderTraversal(currentNode.getRight());
		}
	}
	
	public void inOrderTraversal(){
		Node currentNode = root;
		inOrderTraversal(currentNode);
	}
	private void inOrderTraversal(Node currentNode){
		if(currentNode != null){
			inOrderTraversal(currentNode.getLeft());
			System.out.print("  "+currentNode.getData());
			inOrderTraversal(currentNode.getRight());
		}
	}
	
	public void postOrderTraversal(){
		Node currentNode = root;
		postOrderTraversal(currentNode);
	}
	private void postOrderTraversal(Node currentNode){
		if(currentNode != null){
			postOrderTraversal(currentNode.getLeft());
			postOrderTraversal(currentNode.getRight());
			System.out.print("  "+currentNode.getData());
		}
	}
	
	
	/**
	 * Level order traversal 
	 * 1. visit the root. 
	 * 2. while traversing level l,keep all the elements at level l+1 in queue
	 * 3. Go to the next level and
	 * visit the all nodes.
	 */
	public void BFS() {
		if(this.root ==null ){
			return;
		}
		
		Queue <Node>queue = new LinkedList<Node>();
		queue.add(this.root);

		while( ! queue.isEmpty()){
			Node visitNode = queue.poll();

				System.out.print(" , " + visitNode.getData());
				if (visitNode.getLeft() != null) {
					queue.add(visitNode.getLeft());
				}
				if (visitNode.getRight() != null) {
					queue.add(visitNode.getRight());
				}
			}

	}
	
	/**
	 * Depth first search is same as pre-order traversal. we are using stack,
	 * and insert right node first.
	 */
	public void DFS() {
		Stack<Node> s = new Stack<Node>();
		Node temp = this.getRoot();
		s.push(temp);
		while (!s.isEmpty()) {
			temp = s.pop();
			System.out.print(temp.getData() + " ,");
			if (temp.getRight() != null)
				s.push(temp.getRight());
			if (temp.getLeft() != null)
				s.push(temp.getLeft());
		}
	}

	/**
	 * get right most element from root
	 */
	public int maxElementInBSTTree() {
		if(root ==null){
			return -1;
		}
		Node temp = root;
		while(temp.getRight() != null){
			temp = temp.getRight();
		}
		return temp.getData();
		
	}
	
	
	/**
	 * traversal the given tree in BFS and update max if current Node data is
	 * larger than maxValue
	 */
	public int findMaxUsingBFS() {
		if (root == null) {
			return 0;
		}
		int maxValue = root.getData();
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.getData() > maxValue) {
				maxValue = temp.getData();
			}
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
		return maxValue;
	}

	public boolean serchingUsingBFS(int data) {
		if(this.root ==null){
			return Boolean.FALSE;
		}	
		Queue<Node> q = new LinkedList<Node>();
		q.add(this.root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.getData() == data) {
				return Boolean.TRUE;
			}
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
		return Boolean.FALSE;
	}
	
		/**
	 * size of tree = size of subtree + 1 + size of right subtree
	 */
	public int sizeOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			return sizeOfBinaryTree(root.getLeft()) + 1
					+ sizeOfBinaryTree(root.getRight());
		}
	}

	public int sizeOfBinaryTreeUsingBFS(Node root) {
		if (root == null)
			return 0;

		int count = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			count++;
			Node temp = q.poll();
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
		return count;
	}

	public void deleteTree(Node root) {
		if (root == null) {
			return;
		}
		deleteTree(root.getLeft());
		deleteTree(root.getRight());
		root.setLeft(null);
		root.setRight(null);
		this.root = null;

	}
	
	public void BFSTraversalInReverse(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			System.out.print(temp.getData() + ", ");
			if (temp.getRight() != null)
				q.add(temp.getRight());
			if (temp.getLeft() != null)
				q.add(temp.getLeft());
		}
	}
	
	public boolean areStructurullySameTree(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		return (root1.getData() == root2.getData())
				&& areStructurullySameTree(root1.getLeft(), root2.getLeft())
				&& areStructurullySameTree(root1.getRight(), root2.getRight());
	}
	
	public void maxSumOfLevel() {
		int maxSum = 0;
		int maxWidth = 0;
		
		int currentWidthSum = 0;
		int level = 0;
		int currentWidth = 0;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp == null) {

				if (maxWidth < currentWidth) {
					maxWidth = currentWidth;
				}
				if (currentWidthSum > maxSum) {
					maxSum = currentWidthSum;
				}
				System.out.println("level: " + level + " currentWidth = " + currentWidth + " currentWidthSum = "+currentWidthSum);
				if (!q.isEmpty()) {
					q.add(null);
					currentWidth = 0;
					currentWidthSum = 0;
					level++;
				}
			} else {
				if (temp.getLeft() != null) {
					q.add(temp.getLeft());

				}
				if (temp.getRight() != null) {
					q.add(temp.getRight());
				}
				currentWidth++;
				currentWidthSum += temp.getData();

			}
		}
		System.out.println("Width of the Tree::" + maxWidth);
		System.out.println("Maximum sum of levels::" + maxSum);
	}


	public void printPath(Node root) {
		System.out.println("===============");
		int[] path = new int[10];
		printPath(root, path, 0);
	}

	private void printPath(Node root, int[] path, int pathLength) {
		//System.out.println("\n printPath node: "+ root.getData()+ " , and path "+Arrays.toString(path)+ " pathLength= "+pathLength);
		if (root == null)
			return;
		path[pathLength] = root.getData();
		pathLength++;
		// printing leave node as well as path
		if (root.getLeft() == null && root.getRight() == null) {
			//System.out.println("\n printing leave path path of "+ root.getData());
			printArray(path, pathLength);
		} else {
			printPath(root.getLeft(), path, pathLength);
			printPath(root.getRight(), path, pathLength);
		}
	}

	private void printArray(int[] path, int pathLenght) {
		System.out.println();
		for (int a = 0; a < pathLenght; a++) {
			System.out.print(path[a] + ", ");
		}
	}
	
	public boolean hasPathSum(Node root, int sum) {
		if (root == null) {
			return (sum == 0);
		} else {
			int subSum = sum - root.getData();
			return (hasPathSum(root.getLeft(), subSum) && hasPathSum(
					root.getRight(), subSum));
		}
	}

	public int sumOfAllNodes(Node root) {
		if (root == null) {
			return 0;
		} else {
			return root.getData() + sumOfAllNodes(root.getLeft())
					+ sumOfAllNodes(root.getRight());
		}
	}
	
	/**
	 * create mirror of binary tree
	 * 
	 * @param root
	 */
	public void mirrorOfBinaryTree(Node root) {
		if (root == null) {
			return;
		}
		mirrorOfBinaryTree(root.getLeft());
		mirrorOfBinaryTree(root.getRight());

		Node temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
	}

	public boolean areMirrorBinaryTree(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.getData() != root2.getData()) {
			return false;
		}
		return areMirrorBinaryTree(root1.getLeft(), root2.getRight())
				&& areMirrorBinaryTree(root1.getRight(), root2.getLeft());
	}

	public int getHeight(Node root) {
		if (root == null) {
			return 0;
		} else {
			return (1 + Math.max(getHeight(root.getLeft()),
					getHeight(root.getRight())));
		}
	}
	
	public void zigZagBinaryTreeTraversal(Node root) {
		int height = getHeight(root);
		boolean ltr = true;

		for (int level = 1; level <= height; level++) {
			System.out.println("\n--level------::" + level);
			printNodesOfLevel(root, level, ltr);
			ltr = !ltr;
		}
	}

	public void printNodesOfLevel(Node root, int level, boolean ltr) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.getData() + ", ");
		} else {
			if (ltr == true) {
				printNodesOfLevel(root.getRight(), level - 1, ltr);
				printNodesOfLevel(root.getLeft(), level - 1, ltr);
			} else {
				printNodesOfLevel(root.getLeft(), level - 1, ltr);
				printNodesOfLevel(root.getRight(), level - 1, ltr);
			}
		}
	}

	public void printNthLevelNodes(Node root, int N) {

		if (N == 0 ) {
			System.out.println(root.getData());
		} else if(N > 0){
			if(root.getLeft() != null){
				printNthLevelNodes(root.getLeft(), N - 1);
			}
			if(root.getRight() != null){
				printNthLevelNodes(root.getRight(), N - 1);
			}
		}
	}


	
	public boolean isHeightBalance(Node node) {
		if (node == null) {
			return true;
		} else {
			int lh = getHeight(node.getLeft());
			int lr = getHeight(node.getRight());

			return ((Math.abs(lh - lr) <= 1) && isHeightBalance(node.getLeft()) && isHeightBalance(node
					.getRight()));
		}
	}
	
	public int diameterOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			int lheight = getHeight(root.getLeft());
			int rHeight = getHeight(root.getRight());
			
			int ldiameter = diameterOfBinaryTree(root.getLeft());
			int rdiameter = diameterOfBinaryTree(root.getRight());

			//calculate diameter at current node using height
			int currentNodeDiameter = lheight + rHeight + 1;
			
			// max diameter of subtree left and right
			 int maxDiameterOfSubTree = Math.max(ldiameter, rdiameter);
			
			
			return Math.max(currentNodeDiameter, maxDiameterOfSubTree);
		}
	}

	public boolean isBTisBST(Node root) {

		if (root == null)
			return true;

		if (root.getLeft() != null && root.getLeft().getData() > root.getData()) {
			return false;
		}
		if (root.getRight() != null
				&& root.getRight().getData() < root.getData()) {
			return false;
		}
		if (!isBTisBST(root.getLeft()) || !isBTisBST(root.getRight())) {

			return false;
		}
		return true;
	}

	private void populateHorizontalDistanceForEachNode(Node currentNode, int horizontalDistance, Map<Integer, List<Integer>> hsMap ){
		
		if(currentNode ==null){
			return;
		}
		populateHorizontalDistanceForEachNode(currentNode.getLeft(),  horizontalDistance-1 , hsMap );
		storeHorizontalDistance(currentNode,horizontalDistance,hsMap);
		populateHorizontalDistanceForEachNode(currentNode.getRight(),  horizontalDistance+1 , hsMap );
	}
	
	private void storeHorizontalDistance(Node currentNode, int horizontalDistance, Map<Integer, List<Integer>> hsMap ){
			//System.out.println("---data= " + currentNode.getData() + "---hd----:" + horizontalDistance);
			List<Integer> ls = hsMap.get(horizontalDistance);
			if (ls == null) {
				ls = new ArrayList<Integer>();
				hsMap.put(horizontalDistance, ls);
			}
			ls.add(currentNode.getData());
	}

	public void printVerticalOrder() {
		// the horizontal distance for root element is zero
		Integer horizontalDistance =0;
		Map<Integer, List<Integer>> hsMap = new HashMap<Integer, List<Integer>>();
		populateHorizontalDistanceForEachNode(this.root,  horizontalDistance , hsMap );
		
		Set<Integer> set = hsMap.keySet();
		int max = Collections.max(set);
		int min = Collections.min(set);
		
		for (int i= min ;i<= max;i++){
			System.out.println( "Horizontal distance = "+ i + " values =  "+ hsMap.get(i));
		}
	}
	
	

	public void inOrderTraversalWithoutRecursion(Node root) {
		Node current = root;
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while (!s.isEmpty()) {
			if (current != null) {
				s.push(current);
				current = current.getLeft();
			} else {
				current = s.pop();
				System.out.println(current);
				current = current.getRight();
			}
		}
	}

	public void preOrderTraversalWithoutRecursion(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while (!s.isEmpty()) {
			Node current = s.pop();
			System.out.println(current.getData() + ", ");
			if (current.getRight() != null) {
				s.push(current.getRight());
			}
			if (current.getLeft() != null) {
				s.push(current.getLeft());
			}
		}
	}

	public void postOrderTraversalWithoutRecursion(Node root) {
		Stack<Node> s = new Stack<Node>();
		Node currentNode = root;
		do {
			while (currentNode != null) {
				if (currentNode.getRight() != null) {
					s.push(currentNode.getRight());
				}
				s.push(currentNode);
				currentNode = currentNode.getLeft();
			}
			// now leftmost leave node is in top of stack

			currentNode = s.pop();
			// node have right child and same child is also on top of the stack
			if (currentNode.getRight() != null
					&& s.peek() == currentNode.getRight()) {
				s.pop();
				s.push(currentNode);
				currentNode = currentNode.getRight();
			} else {
				System.out.print(currentNode.getData() + ", ");
				currentNode = null;
			}
		} while (!s.isEmpty());
	}

	public void createDoubleTree(Node root) {
		if (root == null) {
			return;
		} else {
			createDoubleTree(root.getLeft());
			createDoubleTree(root.getRight());

			Node newNode = new Node(root.getData());
			newNode.setLeft(root.getLeft());
			root.setLeft(newNode);
		}
	}

	
	
}
