package tree;

public class MinimumDepthOfBinaryTree {
/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path 
 * from the root node down to the nearest leaf node.
 */
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		if(root.left != null && root.right != null){
			int a = minDepth(root.left);
			int b = minDepth(root.right);
			return a < b ? a + 1 : b + 1;
		}
		if(null == root.left) return minDepth(root.right) + 1;
		else return minDepth(root.left) + 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
