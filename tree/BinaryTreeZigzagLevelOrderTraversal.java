package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	/**
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
	 * (ie, from left to right, then right to left for the next level and alternate between).
	
	For example:
	Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		int depth = height(root);
		List<List<Integer>> ret = new ArrayList<List<Integer>>(depth);
		for(int i = 0; i < depth; i++){
			ret.add(new ArrayList<Integer>());
		}
		DFSvisit(root, ret, 0);
		return ret;
	}
	public void DFSvisit(TreeNode root, List<List<Integer>> list, int i){
		if(root == null){
			return;
		}
		if(i % 2 == 0)
			list.get(i).add(root.val);
		else
			list.get(i).add(0, root.val);
		DFSvisit(root.left, list, i +1);
		DFSvisit(root.right, list, i +1);
	}
	public int height(TreeNode tree){
		if(tree == null) return 0;
		int left = height(tree.left);
		int right = height(tree.right);
		return left > right ? left + 1 : right + 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();
		int[] a = {3,9,20,-1,-1,15,7};
		TreeNode t = Tree.createTree(a);
		Tree.print(s.zigzagLevelOrder(t));
	}

}
