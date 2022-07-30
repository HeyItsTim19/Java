import java.lang.Math;
/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinaryTree implements BinaryTree {
	protected TreeNode root;

	public RefBasedBinaryTree() {
		// TODO...
		root = null;
	}

	public void insert(Integer value){
		insert(null, root, value);
	}

	/*
	 * Purpose: recursively determines the shortest path (root to leaf)
	 *      inserts a new TreeNode with given value at that leaf
	 * Parameters: TreeNode parent - the parent to t
	 *             TreeNode t - the current TreeNode in recursive traversal
	 *             Integer value - the value to be inserted
	 * Returns: nothing
	 */
	private void insert(TreeNode parent, TreeNode t, Integer value) {
		if (t == null) {
			if (parent == null) {
				root = new TreeNode(value);
			} else if (parent.getLeft()==null) {
				parent.setLeft(new TreeNode(value));
			} else {
				parent.setRight(new TreeNode(value));
			}
		} else {
			int htLeft = height(t.getLeft());
			int htRight = height(t.getRight());
			if (htLeft <= htRight) {
				insert(t, t.getLeft(), value);
			} else {
				insert(t, t.getRight(), value);
			}				
		}
	}
	
	
	public int height() {
		return height(root);
	}

	/*
	 * Purpose: computes and returns the height of a 
	 *          binary tree rooted a t 
	 * Parameters: TreeNode t - the BinaryTree
	 * Returns: int - the height
	 * NOTE: a BinaryTree with no node is height 0
	 */
	protected int height(TreeNode t) {
		// TODO...
	if(t == null){
		return 0;
	}
	int left = 1+ height(t.left);
	int right = 1 +  height(t.right);

	if(left>=right){
		return left;
	}
	else{
		return right;
	}

	}
	

	public void inOrder(){
		if(root == null){
			return;
		}

	inOrderRec(root);
	System.out.println("");
		
}

	public void inOrderRec(TreeNode a){
		if(a == null){
			return;
			}

		inOrderRec(a.left);
		System.out.print(a+" ");
		inOrderRec(a.right);
			
}


	public void preOrder(){
		if(root == null){
			return;
		}

		preOrderRec(root);
		System.out.println(" ");
	}


	private void preOrderRec(TreeNode a) {
		if(a==null){
			return;
		}

		System.out.print(a+" ");
		preOrderRec(a.left);
		preOrderRec(a.right);
	}

	public void postOrder(){
		if(root == null){
			return;
		}

		postOrderRec(root);
		System.out.println(" ");
	}

	private void postOrderRec(TreeNode a) {
		if(a==null){
			return;
		}

		postOrderRec(a.left);
		postOrderRec(a.right);
		System.out.print(a+" ");
	}

	/*
	 * Purpose: returns a String reprensentation of this Shape
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		return toString(root);
	}

	private String toString(TreeNode t) {
		if(t == null) {
			return "";
		}
		String s = "";		
		s += toString(t.getLeft());
		s += t.getValue() + " ";
		s += toString(t.getRight());		
		return s;
	}

	// provided for testing of RefBasedBinaryTree class
	public static void main(String[] args) {
		
		RefBasedBinaryTree myTree = new RefBasedBinaryTree();
		for(int i=2; i<=8; i++) {
			myTree.insert(i);
		}
		System.out.println("in:");
		myTree.inOrder();
		System.out.println();
		System.out.println("pre:");
		myTree.preOrder();
		System.out.println();
		System.out.println("post:");
		myTree.postOrder();
		System.out.println();
		
		System.out.println("toString\n" + myTree);
	}
    
}
