package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	/**
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	 * For example:
	 * Given binary tree {3,9,20,#,#,15,7},
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * return its level order traversal as:
	 * [
	 *   [3],
	 *   [9,20],
	 *   [15,7]
	 * ]
	 */
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 1;
        while(!queue.isEmpty()){
        	TreeNode node;
        	List<Integer> a = new ArrayList<Integer>(num);
        	int i = num-1;
        	num = 0;
        	do{
        		node = queue.poll();
                a.add(node.val);
                if(node.left != null){queue.offer(node.left); num++;}
                if(node.right != null){queue.offer(node.right); num++;}
        	}while(i-- > 0);
        	ret.add(a);
        }
        return ret;
    }
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
     
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	if(node == null) break;
        	List<Integer> a = new ArrayList<Integer>();
        	while(node != null){
                a.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
                node = queue.poll();
        	}
        	queue.offer(null);
        	ret.add(a);
        }
        return ret;
    }
	/**
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
	 * (ie, from left to right, level by level from leaf to root).
	For example:
	Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its bottom-up level order traversal as:
	[
	  [15,7],
	  [9,20],
	  [3]
	]
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> r = levelOrder2(root);
		int i = r.size() -1;
		List<List<Integer>> ret = new ArrayList<List<Integer>>(i + 1);
		while(i >= 0){
			ret.add(r.get(i));	
			i--;
		}
		return ret;
    }
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		int depth = height(root);
		List<List<Integer>> ret = new ArrayList<List<Integer>>(depth);
		for(int i = 0; i < depth; i++){
			ret.add(new ArrayList<Integer>());
		}
		DFSvisit(root, ret, depth-1);
		return ret;
	}
	public void DFSvisit(TreeNode root, List<List<Integer>> list, int i){
		if(root == null){
			return;
		}
		list.get(i).add(root.val);
		DFSvisit(root.left, list, i -1);
		DFSvisit(root.right, list, i -1);
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
		BinaryTreeLevelOrderTraversal s = new BinaryTreeLevelOrderTraversal();
		int[] a = {3,9,20,-1,-1,15,7};
		TreeNode t = Tree.createTree(a);
		Tree.print(s.levelOrder(t));
		System.out.println("next");
		Tree.print(s.levelOrder2(t));
		System.out.println("levelOrderBottom");
		Tree.print(s.levelOrderBottom(t));
		System.out.println("next");
		Tree.print(s.levelOrderBottom2(t));
	}

}
