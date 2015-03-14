package tree;

public class BalancedBinaryTree {
	/**
	 * Given a binary tree, determine if it is height-balanced.
	 * For this problem, a height-balanced binary tree is defined as a binary tree 
	 * in which the depth of the two subtrees of every node never differ by more than 1.
	 */
	public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(-1 == height(root)) return false;
        return true;
    }
	public int height(TreeNode root){
		if(root == null) return 0;
		int left = height(root.left);
		if(-1 == left) return -1;
		int right = height(root.right);
		if(-1 == right) return -1;
		if(left - right > 1 || right - left > 1) return -1;
		return (left > right ? left : right) + 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedBinaryTree s = new BalancedBinaryTree();
		int[] a = {1,2,3,4,5,-1,6,-1,-1,7};
		int[] b = {1,2,3,-1,4,-1,5,6};
		TreeNode t1 = Tree.createTree(a);
		TreeNode t2 = Tree.createTree(b);
		System.out.println(s.isBalanced(t1));
		System.out.println(s.isBalanced(t2));
	}

}
