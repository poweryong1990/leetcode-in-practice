package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

	For example, this binary tree is symmetric:
	
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	But the following is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
	Note:
	Bonus points if you could solve it both recursively and iteratively.
	 */
	public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return symmetricTree(root.left, root.right);
    }
	public boolean symmetricTree(TreeNode a, TreeNode b){
		if(a == null && b == null) return true;
		if(a == null || b == null) return false;
		if(a.val != b.val) return false;
		return symmetricTree(a.left, b.right) && symmetricTree(a.right, b.left);
	}
	public boolean isSymmetricIterativeMethod(TreeNode root) {
		if(root == null || root.left == null && root.right == null) return true;
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.offer(root.left);
		q2.offer(root.right);
		while(!q1.isEmpty()){
			TreeNode a = q1.poll();
			TreeNode b = q2.poll();
			if(a == null && b == null) continue;
			if(a == null || b == null) return false;
			if(a.val != b.val) return false;
			q1.offer(a.left);
			q1.offer(a.right);
			q2.offer(b.right);
			q2.offer(b.left);
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymmetricTree s = new SymmetricTree();
		int[] a = {1,2,2,3,4,4,3};
		int[] b = {1,2,2,-1,3,-1,3};
		TreeNode t1 = Tree.createTree(a);
		TreeNode t2 = Tree.createTree(b);
		System.out.println(s.isSymmetric(t1));
		System.out.println(s.isSymmetric(t2));
		System.out.println("iterative method:");
		System.out.println(s.isSymmetricIterativeMethod(t1));
		System.out.println(s.isSymmetricIterativeMethod(t2));
	}

}
