# Applications of tree data structure

Unlike Array and Linked List, which are linear data structures, tree is hierarchical (or non-linear) data structure.

 * One reason to use trees might be because you want to store information that naturally forms a hierarchy. For example, the file system on a computer:
 * If we organize keys in form of a tree (with some ordering e.g., BST), we can search for a given key in moderate time (quicker than Linked List and slower than arrays). Self-balancing search trees like AVL and Red-Black trees guarantee an upper bound of O(Logn) for search.
 * We can insert/delete keys in moderate time (quicker than Arrays and slower than Unordered Linked Lists). Self-balancing search trees like AVL and Red-Black trees guarantee an upper bound of O(Logn) for insertion/deletion.
 * Like Linked Lists and unlike Arrays, Pointer implementation of trees don’t have an upper limit on number of nodes as nodes are linked using pointers.
 
 * Router algorithms
 
# Tree Traversals (Inorder, Preorder and Postorder)
 
* Depth First Traversals:
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1

 * Breadth First or Level Order Traversal : 1 2 3 4 5