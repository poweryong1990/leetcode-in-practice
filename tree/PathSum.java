package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
	 * such that adding up all the values along the path equals the given sum.
	
	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \      \
	        7    2      1
	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right == null) return root.val == sum;
		int differ = sum - root.val;
//		if(differ <= 0) return false;//sum can be negative.
		if(root.left == null) return hasPathSum(root.right, differ);
		if(root.right == null) return hasPathSum(root.left, differ);
		return hasPathSum(root.left, differ) || hasPathSum(root.right, differ);
    }
	/**
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	
	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        list = helper(root,sum);
        for(List<Integer> a: list){
        	int i = 0, j = a.size()-1;
        	while(i < j){
        		int x = a.get(i);
        		int y = a.get(j);
        		a.set(i, y);
        		a.set(j, x);
        		i++;
        		j--;
        	}
        }
        return list;
    }
	List<List<Integer>> helper(TreeNode root, int sum){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root.left == null && root.right == null){
			if(root.val == sum){
				List<Integer> a = new ArrayList<Integer>();
				a.add(sum);
				list.add(a);
			}
		}else if(root.left == null){
			list = helper(root.right, sum - root.val);
			for(List<Integer> l: list){
				l.add(root.val);
			}
		}else if(root.right == null){
			list = helper(root.left, sum - root.val);
			for(List<Integer> l: list){
				l.add(root.val);
			}
		}else{
			list = helper(root.left, sum - root.val);
			list.addAll(helper(root.right, sum - root.val));
			for(List<Integer> l: list){
				l.add(root.val);
			}
		}
		return list;	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSum s = new PathSum();
		int[] a = {5,4,8,11,-1,13,4,7,2,-1,-1,-1,1};
		int[] b = {5,4,8,21,-1,13,4,7,2,-1,-1,-1,1};
		int[] c = {-2,-1,-3};
		TreeNode t1 = Tree.createTree(a);
		TreeNode t2 = Tree.createTree(b);
		TreeNode t3 = Tree.createTree(c);
		System.out.println(s.hasPathSum(t1, 22));
		System.out.println(s.hasPathSum(t2, 22));
		System.out.println(s.hasPathSum(t3, -5));
		
		TreeNode t4 = Tree.createTree(5,4,8,11,-1,13,4,7,2,-1,-1,5,1);
		Tree.print(s.pathSum(t4, 22));
	}

}
