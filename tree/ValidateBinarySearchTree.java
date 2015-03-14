package tree;

public class ValidateBinarySearchTree {
	/**
	 * Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	 */
	public boolean isValidBST(TreeNode root) {
		if(root == null || root.left == null && root.right == null) return true;
		if(root.left == null) return root.val < rightMin(root.right) && isValidBST(root.right);
		if(root.right == null) return leftMax(root.left) < root.val && isValidBST(root.left);
		return leftMax(root.left) < root.val && root.val < rightMin(root.right) && isValidBST(root.left) && isValidBST(root.right);
    }
	int rightMin(TreeNode right){
		while(right.left != null){
			right = right.left;
		}
		return right.val;
	}
	int leftMax(TreeNode left){
		while(left.right != null){
			left = left.right;
		}
		return left.val;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateBinarySearchTree s = new ValidateBinarySearchTree();
		int[] a = {10,5,15,-1,-1,6,20};
		TreeNode t1 = Tree.createTree(a);
		System.out.println(s.isValidBST(t1));
	}

}
