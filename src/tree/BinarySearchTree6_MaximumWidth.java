package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree6_MaximumWidth {
	
	
	public int  getMaxWidthUsingRecursion(Node root){
		
		int height = getHeight(root);
		int maxWidth =0;
		for(int i=1;i<= height;i++){
			int width = getWidthOfGivenLevel(root, i);
			if(maxWidth < width)
				maxWidth = width;
		}		
		return maxWidth;
	}
	
	private int getWidthOfGivenLevel(Node root, int level){
		if(root == null)
			return 0;
		else if(level ==1)
			return 1;
		else{
		 return  getWidthOfGivenLevel(root.getLeft(),level-1) + getWidthOfGivenLevel(root.getRight(), level -1);
		}
	}
	
	private int getHeight(Node root) {
		if (root == null) {
			return 0;
		} else {
			return (1 + Math.max(getHeight(root.getLeft()),
					getHeight(root.getRight())));
		}
	}
	
	
	public int getMaxWidthUsingBST(Node root){
		
		Queue<Node>  queue = new LinkedList<Node>();
		queue.add(root);
		int maxwidth = 0;
		while(!queue.isEmpty()){
			
			int count = queue.size();	
			maxwidth = Math.max(maxwidth, count);
			while(count>0){
				count--;
				Node  node = queue.remove();
				//System.out.println(node.getData());
				if(node.getLeft() != null){
					queue.add(node.getLeft());
				}
				if(node.getRight() != null){
					queue.add(node.getRight());
				}
			}
		}
		return maxwidth;
	}
	
	public int getMaxWidthUsingPreorderTraversal(Node root){
		int height = getHeight(root);
		int width[] = new int[height];
		for(int i=0; i< width.length ;i++)
			width[i]= 0;
		// width[0] indicate the count of node on first level
		preOrderTraversal(root,width,0);
		
		int max = 0;
		for(int count : width){
			max = max < count ? count :max;
		}
		return max;
		
	}
	
	private void preOrderTraversal(Node root,int []width, int level){
		if(root != null){
			//System.out.println(root.getData());
			width[level]++;
			preOrderTraversal(root.getLeft(), width,level+1);
			preOrderTraversal(root.getRight(), width, level+1 );
		}
	}

	public static void main(String[] args) throws InterruptedException {
		BinarySearchTree bst = new BinarySearchTree(new Node(30));
		bst.addMultipleNode( new Node(10), new Node(40),
				new Node(45), new Node(35), new Node(25), new Node(5),
				new Node(7), new Node(4) );
		
		BinarySearchTree6_MaximumWidth tree = new BinarySearchTree6_MaximumWidth();
		System.out.println(tree.getMaxWidthUsingRecursion(bst.getRoot()));
		System.out.println(tree.getMaxWidthUsingBST(bst.getRoot()));
		System.out.println(tree.getMaxWidthUsingPreorderTraversal(bst.getRoot()));
	}

}
