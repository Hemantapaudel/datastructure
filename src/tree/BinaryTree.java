package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public BinaryTree(Node node) {
		
		this.root= node;
	}
	
	/**
	 * compare root data , leftNode data value and rightNode data recursively
	 */
	public int maxElementInBTree(Node root) {
		int rootValue, left, right, max = 0;
		if (root != null) {
			rootValue = root.getData();
			left = maxElementInBTree(root.getLeft());
			right = maxElementInBTree(root.getRight());

			if (left > right) {
				max = left;
			} else {
				max = right;
			}
			if (rootValue > max) {
				max = rootValue;
			}
		}
		return max;
	}
	
	
	/**
	 * Traversal the tree in BST and insert at last
	 */
	public void insertInBinaryTree(Node root, Node newNode) {
		if (root == null) {
			this.root = newNode;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(this.root);
		while (!q.isEmpty()) {
			Node temp = q.poll();

			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			} else {
				System.out.println("inserting on left child of::"
						+ temp.getData());
				temp.setLeft(newNode);
				return;
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			} else {
				System.out.println("inserting on right child of::"
						+ temp.getData());
				temp.setRight(newNode);
				return;
			}
		}
	}
	
	public Node deepestNodeinBinaryTree(Node root) {
		Node temp = root;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp.getRight() != null)
				q.add(temp.getRight());
			if (temp.getLeft() != null)
				q.add(temp.getLeft());
		}
		return temp;
	}
	
	public int numberOfLeavesInBTree(Node root) {
		int count = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.getLeft() == null && temp.getRight() == null) {
				count++;
			}

			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}

		}
		return count;
	}
	
	public int numberOfFullNodesInBTree(Node root) {
		int count = 0;
		if (root == null) {
			return count;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.getLeft() != null && temp.getRight() != null) {
				count++;
			}
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
		return count;
	}
	
	public int numberOfHalfNodesInBTree(Node root) {
		int count = 0;
		if (root == null) {
			return count;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if ((temp.getLeft() != null && temp.getRight() == null)
					|| (temp.getLeft() == null && temp.getRight() != null)) {
				count++;
			}
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
		return count;
	}

}
