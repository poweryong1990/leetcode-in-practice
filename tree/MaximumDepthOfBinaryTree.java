package tree;

public class MaximumDepthOfBinaryTree {
	/**
	 * Given a binary tree, find its maximum depth.
	 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	 */
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		int a = maxDepth(root.left);
		int b = maxDepth(root.right);
		return a > b ? a + 1 : b + 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
